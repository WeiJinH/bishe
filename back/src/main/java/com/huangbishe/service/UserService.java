
package com.huangbishe.service;

import java.util.List;
import java.util.Map;

import com.huangbishe.entity.UserEntity;
import com.huangbishe.utils.PageUtils;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;


/**
 * 系统用户
 */
public interface UserService extends IService<UserEntity> {
 	PageUtils queryPage(Map<String, Object> params);
    
   	List<UserEntity> selectListView(Wrapper<UserEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<UserEntity> wrapper);
	   	
}
