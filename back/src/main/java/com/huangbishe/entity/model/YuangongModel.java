package com.huangbishe.entity.model;

import lombok.Data;

import java.io.Serializable;
 

/**
 * 员工
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 */
@Data
public class YuangongModel  implements Serializable {
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
