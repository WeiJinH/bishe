package com.huangbishe.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.huangbishe.entity.YuangongqingjiaEntity;
import com.huangbishe.entity.view.YuangongqingjiaView;
import com.huangbishe.utils.MPUtil;
import com.huangbishe.utils.PageUtils;
import com.huangbishe.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.huangbishe.service.YuangongqingjiaService;


/**
 * 员工请假
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-20 16:37:02
 */
@RestController
@RequestMapping("/yuangongqingjia")
public class YuangongqingjiaController {
    @Autowired
    private YuangongqingjiaService yuangongqingjiaService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YuangongqingjiaEntity yuangongqingjia,
                  HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			yuangongqingjia.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuangongqingjiaEntity> ew = new EntityWrapper<YuangongqingjiaEntity>();
		PageUtils page = yuangongqingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongqingjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongqingjiaEntity yuangongqingjia, 
		HttpServletRequest request){
        EntityWrapper<YuangongqingjiaEntity> ew = new EntityWrapper<YuangongqingjiaEntity>();
		PageUtils page = yuangongqingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongqingjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongqingjiaEntity yuangongqingjia){
       	EntityWrapper<YuangongqingjiaEntity> ew = new EntityWrapper<YuangongqingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangongqingjia, "yuangongqingjia")); 
        return R.ok().put("data", yuangongqingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongqingjiaEntity yuangongqingjia){
        EntityWrapper< YuangongqingjiaEntity> ew = new EntityWrapper< YuangongqingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangongqingjia, "yuangongqingjia")); 
		YuangongqingjiaView yuangongqingjiaView =  yuangongqingjiaService.selectView(ew);
		return R.ok("查询员工请假成功").put("data", yuangongqingjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongqingjiaEntity yuangongqingjia = yuangongqingjiaService.selectById(id);
        return R.ok().put("data", yuangongqingjia);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongqingjiaEntity yuangongqingjia = yuangongqingjiaService.selectById(id);
        return R.ok().put("data", yuangongqingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongqingjiaEntity yuangongqingjia, HttpServletRequest request){
    	yuangongqingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongqingjia);
        yuangongqingjiaService.insert(yuangongqingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongqingjiaEntity yuangongqingjia, HttpServletRequest request){
    	yuangongqingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongqingjia);
        yuangongqingjiaService.insert(yuangongqingjia);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YuangongqingjiaEntity yuangongqingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangongqingjia);
        yuangongqingjiaService.updateById(yuangongqingjia);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongqingjiaService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YuangongqingjiaEntity> wrapper = new EntityWrapper<YuangongqingjiaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			wrapper.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yuangongqingjiaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
