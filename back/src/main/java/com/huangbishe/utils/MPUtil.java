package com.huangbishe.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cn.hutool.core.bean.BeanUtil;

import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * Mybatis-Plus工具类,
 * 这个工具类主要是为了简化Mybatis-Plus的条件构造，
 * 将前端传来的参数（可能是驼峰命名）转换为数据库字段的下划线命名，
 * 并构建相应的查询条件，比如等于、模糊查询、范围查询和排序等。
 * 这样在Service层可以更方便地组装查询条件，避免手动处理字段名的转换和多个条件的拼接。
 */
public class MPUtil {
	public static final char UNDERLINE = '_';

	/**
	 * 在allEQMapPre和allEQMap方法中，使用BeanUtil.beanToMap将对象转为Map，
	 * 然后通过camelToUnderlineMap处理键名，
	 * 可能是为了将Java对象的驼峰属性名转换为数据库字段的下划线命名，
	 * 这样在使用Mybatis-Plus的allEq方法时可以直接匹配数据库字段。

	 */
	//mybatis plus allEQ 表达式转换
		public static Map allEQMapPre(Object bean,String pre) {
		   Map<String, Object> map =BeanUtil.beanToMap(bean);
		  return camelToUnderlineMap(map,pre);
	   }

		//mybatis plus allEQ 表达式转换
		public static Map allEQMap(Object bean) {
		   Map<String, Object> map =BeanUtil.beanToMap(bean);
		   return camelToUnderlineMap(map,"");
	   }

	   //将JavaBean转为带前缀的下划线格式Map，生成多个LIKE条件
		public static Wrapper allLikePre(Wrapper wrapper,Object bean,String pre) {
			   Map<String, Object> map =BeanUtil.beanToMap(bean);
			   Map result = camelToUnderlineMap(map,pre);
			 
			return genLike(wrapper,result);
		}

		//直接使用Bean属性名（需与数据库字段名一致），生成多个LIKE条件。
		public static Wrapper allLike(Wrapper wrapper,Object bean) {
			  Map result = BeanUtil.beanToMap(bean, true, true);			 
			return genLike(wrapper,result);
		}


		//遍历Map，生成LIKE条件链。
		//示例：param = {"name": "Tom"} → WHERE name LIKE '%Tom%'
		public static Wrapper genLike( Wrapper wrapper,Map param) {
			Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
			int i=0;
			while (it.hasNext()) {
				if(i>0) wrapper.and();
				Map.Entry<String, Object> entry = it.next();
				String key = entry.getKey();
				String value = (String) entry.getValue();
				wrapper.like(key, value);
				i++;
			}
			return wrapper;
		}


		//根据值是否包含%，动态选择LIKE或EQ条件。
		//示例：{"name": "%Tom"} → name LIKE '%Tom%'，{"age": 20} → age = 20
		public static Wrapper likeOrEq(Wrapper wrapper,Object bean) {
			  Map result = BeanUtil.beanToMap(bean, true, true);			 
			return genLikeOrEq(wrapper,result);
		}
		
		public static Wrapper genLikeOrEq( Wrapper wrapper,Map param) {
			Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
			int i=0;
			while (it.hasNext()) {
				if(i>0) wrapper.and();
				Map.Entry<String, Object> entry = it.next();
				String key = entry.getKey();
				if(entry.getValue().toString().contains("%")) {
					wrapper.like(key, entry.getValue().toString().replace("%", ""));
				} else {
					wrapper.eq(key, entry.getValue());
				}
				i++;
			}
			return wrapper;
		}


		public static Wrapper allEq(Wrapper wrapper,Object bean) {
			  Map result = BeanUtil.beanToMap(bean, true, true);			 
			return genEq(wrapper,result);
		}
	


		public static Wrapper genEq( Wrapper wrapper,Map param) {
			Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
			int i=0;
			while (it.hasNext()) {
				if(i>0) wrapper.and();
				Map.Entry<String, Object> entry = it.next();
				String key = entry.getKey();
				wrapper.eq(key, entry.getValue());
				i++;
			}
			return wrapper;
		}

	/**
	 * 处理以_start和_end结尾的参数，生成范围条件。
	 * 示例：{"age_start": 18, "age_end": 30} → WHERE age >= 18 AND age <= 30
 	 * @param wrapper
	 * @param params
	 * @return
	 */

		public static Wrapper between(Wrapper wrapper,Map<String, Object> params) {
			for(String key : params.keySet()) {
				String columnName = "";
				if(key.endsWith("_start")) {
					columnName = key.substring(0, key.indexOf("_start"));
					if(StringUtils.isNotBlank(params.get(key).toString())) {
						wrapper.ge(columnName, params.get(key));
					}
				}
				if(key.endsWith("_end")) {
					columnName = key.substring(0, key.indexOf("_end"));
					if(StringUtils.isNotBlank(params.get(key).toString())) {
						wrapper.le(columnName, params.get(key));
					}
				}
			}
			return wrapper;
		}


	/**
	 *根据sort和order参数设置排序。
	 * 示例：sort=createTime&order=desc → ORDER BY create_time DESC
	 * @param wrapper
	 * @param params
	 * @return
	 */
	public static Wrapper sort(Wrapper wrapper,Map<String, Object> params) {
			String order = "";
			if(params.get("order") != null && StringUtils.isNotBlank(params.get("order").toString())) {
				order = params.get("order").toString();
			}
			if(params.get("sort") != null && StringUtils.isNotBlank(params.get("sort").toString())) {
				if(order.equalsIgnoreCase("desc")) {
					wrapper.orderDesc(Arrays.asList(params.get("sort")));
				} else {
					wrapper.orderAsc(Arrays.asList(params.get("sort")));
				}
			}
			return wrapper;
		}
	
	
	/**
	 * 驼峰格式字符串转换为下划线格式字符串
	 * 
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] ages) {

		System.out.println(camelToUnderline("ABCddfANM"));
	}
	
	public static Map camelToUnderlineMap(Map param, String pre) {

		Map<String, Object> newMap = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = camelToUnderline(key);
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {

				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		return newMap;
	}
}
