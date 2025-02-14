package com.huangbishe.entity.view;

import com.huangbishe.entity.KaoqinjidianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 考勤基点
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("kaoqinjidian")
public class KaoqinjidianView  extends KaoqinjidianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaoqinjidianView(){
	}
 
 	public KaoqinjidianView(KaoqinjidianEntity kaoqinjidianEntity){
 	try {
			BeanUtils.copyProperties(this, kaoqinjidianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
