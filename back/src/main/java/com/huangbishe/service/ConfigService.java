
package com.huangbishe.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.huangbishe.entity.ConfigEntity;
import com.huangbishe.utils.PageUtils;


/**
 * 系统用户
 */
public interface ConfigService extends IService<ConfigEntity> {
	PageUtils queryPage(Map<String, Object> params);
}
