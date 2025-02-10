package com.huangbishe.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.huangbishe.entity.YuangongchuchaiEntity;
import com.huangbishe.entity.view.YuangongchuchaiView;
import com.huangbishe.service.YuangongchuchaiService;
import com.huangbishe.utils.MPUtil;
import com.huangbishe.utils.PageUtils;
import com.huangbishe.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;



@RestController
@RequestMapping("/yuangongchuchai")
public class YuangongchuchaiController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private YuangongchuchaiService yuangongchuchaiService;



    /**
     * 后端列表
     * 管理员和员工都可以使用。
     * 如果是管理员，没有查询限制，可以获取所有员工的出差数据。
     * 如果是员工，只会返回自己（根据员工编号 yuangonggonghao）的出差数据。
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YuangongchuchaiEntity yuangongchuchai,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();//从Session中获取tableName，用于区分当前用户的角色或身份（例如"员工"）。
        if(tableName.equals("yuangong")) {
            yuangongchuchai.setYuangonggonghao((String)request.getSession().getAttribute("username"));
        }
        //如果tableName为"yuangong"，即当前用户为员工角色，则从Session中提取用户名（通常为员工编号），并设置到yuangongchuchai对象的yuangonggonghao属性中，作为查询条件。
        EntityWrapper<YuangongchuchaiEntity> ew = new EntityWrapper<YuangongchuchaiEntity>();
        PageUtils page = yuangongchuchaiService.queryPage(
                params, MPUtil.sort(
                        MPUtil.between(
                                MPUtil.likeOrEq(ew, yuangongchuchai), params)
                        , params));
        //利用MPUtil处理模糊匹配、区间查询和排序等复杂操作
        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     * 提供前端展示用的分页数据列表。
     * 管理员使用
     * 不做用户角色判断。
     * 返回的数据没有明确的限制（完全取决于传入的查询条件）。
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongchuchaiEntity yuangongchuchai,
                  HttpServletRequest request){
        EntityWrapper<YuangongchuchaiEntity> ew = new EntityWrapper<YuangongchuchaiEntity>();
        PageUtils page = yuangongchuchaiService.queryPage(
                params, MPUtil.sort(
                        MPUtil.between(
                                MPUtil.likeOrEq(ew, yuangongchuchai), params)
                        , params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     * 是一个更为简单的接口，返回的不是分页数据，而是完整的列表（可能用于下拉框、静态选项等场景）。
     */
    @RequestMapping("/lists")
    public R list( YuangongchuchaiEntity yuangongchuchai){
        EntityWrapper<YuangongchuchaiEntity> ew = new EntityWrapper<YuangongchuchaiEntity>();
        ew.allEq(MPUtil.allEQMapPre( yuangongchuchai, "yuangongchuchai"));
        return R.ok().put("data", yuangongchuchaiService.selectListView(ew));
    }

    /**
     * 查询
     *用途：管理员和员工都可用。
     * 说明：根据条件（从 yuangongchuchai 实体的字段）查询单条记录的详细信息。
     * 特点：没有对用户角色进行限制，管理员可以查询任意记录，员工也可以用它查询符合条件的记录。
     */
    @RequestMapping("/query")
    public R query(YuangongchuchaiEntity yuangongchuchai){
        EntityWrapper< YuangongchuchaiEntity> ew = new EntityWrapper< YuangongchuchaiEntity>();
        ew.allEq(MPUtil.allEQMapPre( yuangongchuchai, "yuangongchuchai"));
        YuangongchuchaiView yuangongchuchaiView =  yuangongchuchaiService.selectView(ew);
        return R.ok("查询员工出差成功").put("data", yuangongchuchaiView);
    }

    /**
     * 后端详情
     * 用途：管理员用。
     * 说明：根据记录的 id 获取后端详细信息，通常是管理员后台系统使用。
     * 特点：没有对角色做限制，但一般只有管理员可以调用。
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongchuchaiEntity yuangongchuchai = yuangongchuchaiService.selectById(id);
        return R.ok().put("data", yuangongchuchai);
    }

    /**
     * 前端详情
     * 用途：员工用。
     * 说明：前端接口，提供根据 id 获取的详细信息，主要供员工查看自己的数据。
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongchuchaiEntity yuangongchuchai = yuangongchuchaiService.selectById(id);
        return R.ok().put("data", yuangongchuchai);
    }




    /**
     * 后端保存
     * 用途：管理员用。
     * 说明：后端接口，用于保存新的出差记录，通常管理员在后台添加数据时使用。
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongchuchaiEntity yuangongchuchai, HttpServletRequest request){
        yuangongchuchai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(yuangongqingjia);
        yuangongchuchaiService.insert(yuangongchuchai);
        return R.ok();
    }

    /**
     * 前端保存
     * 用途：员工用。
     * 说明：前端接口，员工自己提交新的出差申请。
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongchuchaiEntity yuangongchuchai, HttpServletRequest request){
        yuangongchuchai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(yuangongqingjia);
        yuangongchuchaiService.insert(yuangongchuchai);
        return R.ok();
    }

    /**
     * 修改
     * 用途：管理员和员工都可用。
     * 说明：更新出差记录。
     * 特点：虽然接口没有明确限制角色，但通常管理员可以修改任意记录，员工只能修改自己的记录。
     */
    @RequestMapping("/update")
    public R update(@RequestBody YuangongchuchaiEntity yuangongchuchai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangongqingjia);
        yuangongchuchaiService.updateById(yuangongchuchai);//全部更新
        return R.ok();
    }


    /**
     * 删除
     * 用途：管理员用。
     * 说明：根据 id 数组批量删除记录，一般只有管理员有权限删除数据。
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongchuchaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     * 用途：管理员和员工都可用。
     * 说明：用于计算符合提醒条件的记录数量。
     * 特点：
     * 如果当前登录用户是管理员（tableName != "yuangong"），则统计所有数据。
     * 如果是员工（tableName == "yuangong"），则只统计与当前员工相关的数据。
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
        //记录提醒参数
        map.put("column", columnName);
        map.put("type", type);
        //如果 type = 2，动态计算提醒日期范围
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
        //构建查询条件
        Wrapper<YuangongchuchaiEntity> wrapper = new EntityWrapper<YuangongchuchaiEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }
        //根据用户角色动态调整查询条件
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yuangong")) {
            wrapper.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
        }
        //执行统计查询并返回结果
        int count = yuangongchuchaiService.selectCount(wrapper);
        return R.ok().put("count", count);
    }

    @RequestMapping("/barCountOne")
    public R barCountOne(@RequestParam Map<String,Object> params) {
        logger.debug("柱状图统计单列:,,Controller:{},,params:{}",this.getClass().getName(),params);
        List<Map<String, Object>> result = yuangongchuchaiService.barCountOne(params);

        List<String> xAxis = new ArrayList<>();//报表x轴
        List<List<String>> yAxis = new ArrayList<>();//y轴
        List<String> legend = new ArrayList<>();//标题

        List<String> yAxis0 = new ArrayList<>();
        yAxis.add(yAxis0);
        legend.add("");
        for(Map<String, Object> map :result){
            String oneValue = String.valueOf(map.get("name"));
            String value = String.valueOf(map.get("value"));
            xAxis.add(oneValue);
            yAxis0.add(value);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("xAxis",xAxis);
        resultMap.put("yAxis",yAxis);
        resultMap.put("legend",legend);
        return R.ok().put("data", resultMap);
    }
}
