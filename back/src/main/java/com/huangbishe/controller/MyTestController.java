package com.huangbishe.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huangbishe.annotation.IgnoreAuth;
import com.huangbishe.entity.UserEntity;
import com.huangbishe.entity.YuangongEntity;
import com.huangbishe.service.UserService;
import com.huangbishe.service.YuangongService;
import com.huangbishe.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
public class MyTestController {
    @Autowired
    UserService userService;

    @RequestMapping("/one")
    public R test() {

        EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
        return R.ok().put("data", userService.selectListView(ew));
    }

    //    @RequestMapping( "/two")
//    public R test2(HttpServletRequest request){
//        String name = request.getHeader("name");
//        String ageStr = request.getHeader("age");
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name+":"+age);
//        return R.ok();
//    }
    //简单参数
    @RequestMapping("/two")
    public R test2(String name, Integer age) {
        System.out.println(name + ":" + age);
        return R.ok();
    }

    //实体参数
    @RequestMapping("/three")
    public R test3(UserEntity user) {
        System.out.println(user);
        return R.ok();
    }

    //数组参数
    @RequestMapping("/arryParam")
    public R arryParam(@RequestParam String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return R.ok();
    }

    //集合参数
    @RequestMapping("/listParam")
    public R listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return R.ok();
    }

    //日期参数
    @RequestMapping("/dateParam")
    public R dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime update) {
        System.out.println(update);
        return R.ok();
    }

    //json参数
    @RequestMapping("/jsonParam")
    public R jsonParam(@RequestBody UserEntity user) {
        System.out.println(user);
        return R.ok();
    }

    //路径参数
    @RequestMapping("/{id}/{name}")
    public R finById(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id + ":" + name);
        return R.ok();
    }

}