package com.huangbishe.entity.vo;

import lombok.Data;

import java.io.Serializable;
 

/**
 * 员工
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 */
@Data
public class YuangongVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 年龄
	 */
	
	private String nianling;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 邮箱
	 */
	
	private String youxiang;
		
	/**
	 * 部门
	 */
	
	private String bumen;
		
	/**
	 * 个人职位
	 */
	
	private String gerenzhiwei;
		
	/**
	 * 在职情况
	 */
	
	private String zaizhiqingkuang;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 家庭住址
	 */
	
	private String jiatingzhuzhi;

			
}
