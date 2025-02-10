package com.huangbishe.entity.view;

import com.huangbishe.entity.BumenxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 部门信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bumenxinxi")
public class BumenxinxiView  extends BumenxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BumenxinxiView(){
	}
 
 	public BumenxinxiView(BumenxinxiEntity bumenxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, bumenxinxiEntity);
		// 将yuangongqingjiaEntity的属性复制到当前对象（YuangongqingjiaView）中
		} catch (IllegalAccessException | InvocationTargetException e) {
		// 处理异常，这里简单地打印堆栈跟踪，实际应用中可能需要更复杂的错误处理
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
