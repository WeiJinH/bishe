package com.huangbishe.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaiduUtil {

    private static final Logger logger = LoggerFactory.getLogger(BaiduUtil.class);
    private static final String BAIDU_API_URL = "http://api.map.baidu.com/reverse_geocoding/v3/";

    public static Map<String, String> getCityByLonLat(String key, String lng, String lat) {
        try {
            // 构建请求URL
            String urlStr = BAIDU_API_URL + "?ak=" + key + "&output=json&coordtype=wgs84ll&location=" + lat + "," + lng;

            // 发送HTTP请求
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // 读取响应
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // 解析JSON响应
            JSONObject jsonResponse = new JSONObject(response.toString());

            // 检查是否有错误信息
            if (jsonResponse.has("status") && jsonResponse.getInt("status") != 0) {
                logger.error("Baidu API error: {}", jsonResponse.getString("message")); // 修改此处
                return null;
            }

            // 检查 "result" 键是否存在
            if (!jsonResponse.has("result")) {
                logger.warn("No 'result' key found in the response from Baidu API.");
                return null;
            }

            JSONObject result = jsonResponse.getJSONObject("result");

            // 获取地址组件
            JSONObject addressComponent = result.getJSONObject("addressComponent");

            // 获取 province、city、district 和 street
            String province = addressComponent.has("province") ? addressComponent.getString("province") : "";
            String city = addressComponent.has("city") ? addressComponent.getString("city") : "";
            String district = addressComponent.has("district") ? addressComponent.getString("district") : "";
            String street = addressComponent.has("street") ? addressComponent.getString("street") : "";

            // 返回结果
            Map<String, String> cityInfo = new HashMap<>();
            cityInfo.put("province", province);
            cityInfo.put("city", city);
            cityInfo.put("district", district);
            cityInfo.put("street", street);

            return cityInfo;

        } catch (Exception e) {
            logger.error("Error occurred while fetching location info from Baidu API", e);
            return null;
        }
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return access_token
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            org.json.JSONObject jsonObject = new org.json.JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }
}
