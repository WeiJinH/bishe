package com.huangbishe.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.huangbishe.annotation.IgnoreAuth;
import com.huangbishe.entity.KaoqinjidianEntity;
import com.huangbishe.entity.view.KaoqinjidianView;
import com.huangbishe.service.KaoqinjidianService;
import com.huangbishe.utils.BaiduUtil;
import com.huangbishe.utils.MPUtil;
import com.huangbishe.utils.PageUtils;
import com.huangbishe.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;


/**
 * 考勤基点
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
@RestController
@RequestMapping("/kaoqinjidian")
public class KaoqinjidianController {
    @Autowired
    private KaoqinjidianService kaoqinjidianService;



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, KaoqinjidianEntity kaoqinjidian,
				  HttpServletRequest request){
        EntityWrapper<KaoqinjidianEntity> ew = new EntityWrapper<KaoqinjidianEntity>();
		PageUtils page = kaoqinjidianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoqinjidian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaoqinjidianEntity kaoqinjidian, 
		HttpServletRequest request){
        EntityWrapper<KaoqinjidianEntity> ew = new EntityWrapper<KaoqinjidianEntity>();
		PageUtils page = kaoqinjidianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoqinjidian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaoqinjidianEntity kaoqinjidian){
       	EntityWrapper<KaoqinjidianEntity> ew = new EntityWrapper<KaoqinjidianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaoqinjidian, "kaoqinjidian")); 
        return R.ok().put("data", kaoqinjidianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaoqinjidianEntity kaoqinjidian){
        EntityWrapper< KaoqinjidianEntity> ew = new EntityWrapper< KaoqinjidianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaoqinjidian, "kaoqinjidian")); 
		KaoqinjidianView kaoqinjidianView =  kaoqinjidianService.selectView(ew);
		return R.ok("查询考勤基点成功").put("data", kaoqinjidianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaoqinjidianEntity kaoqinjidian = kaoqinjidianService.selectById(id);
		kaoqinjidian.setClicknum(kaoqinjidian.getClicknum()+1);
		kaoqinjidian.setClicktime(new Date());
		kaoqinjidianService.updateById(kaoqinjidian);
        return R.ok().put("data", kaoqinjidian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaoqinjidianEntity kaoqinjidian = kaoqinjidianService.selectById(id);
		kaoqinjidian.setClicknum(kaoqinjidian.getClicknum()+1);
		kaoqinjidian.setClicktime(new Date());
		kaoqinjidianService.updateById(kaoqinjidian);
        return R.ok().put("data", kaoqinjidian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaoqinjidianEntity kaoqinjidian, HttpServletRequest request){
    	kaoqinjidian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaoqinjidian);
        kaoqinjidianService.insert(kaoqinjidian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaoqinjidianEntity kaoqinjidian, HttpServletRequest request){
    	kaoqinjidian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaoqinjidian);
        kaoqinjidianService.insert(kaoqinjidian);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody KaoqinjidianEntity kaoqinjidian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaoqinjidian);
        kaoqinjidianService.updateById(kaoqinjidian);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaoqinjidianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<KaoqinjidianEntity> wrapper = new EntityWrapper<KaoqinjidianEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = kaoqinjidianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,KaoqinjidianEntity kaoqinjidian, HttpServletRequest request,String pre){
        EntityWrapper<KaoqinjidianEntity> ew = new EntityWrapper<KaoqinjidianEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = kaoqinjidianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoqinjidian), params), params));
        return R.ok().put("data", page);
    }


	private static final Logger logger = LoggerFactory.getLogger(KaoqinjidianController.class);



	@GetMapping("/api/location")
	public R getLocationInfo(
			@RequestParam String key,
			@RequestParam String lng,
			@RequestParam String lat) {
		Map<String, String> cityByLonLat = BaiduUtil.getCityByLonLat(key, lng, lat);
		if (cityByLonLat == null || cityByLonLat.isEmpty()) {
			// 添加日志记录，方便调试
			logger.error("Failed to get location info from Baidu API with key: {}, lng: {}, lat: {}", key, lng, lat);
			return R.error("Failed to get location info");
		}
		// 打印返回的Map内容，方便调试
		logger.info("Location info from Baidu API: {}", cityByLonLat);
		return R.ok().put("data", cityByLonLat);
	}




}
