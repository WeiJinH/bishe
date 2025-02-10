package com.huangbishe.entity.vo;

import lombok.Data;

import java.io.Serializable;
 

/**
 * 部门信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 */
@Data
public class BumenxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 部门名称
	 */
	
	private String bumenmingcheng;
		
	/**
	 * 部门介绍
	 */
	
	private String bumenjieshao;
	/**
	 * test
	 */

	private String beizhu;
			
}
