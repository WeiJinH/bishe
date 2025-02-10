package com.huangbishe.entity.model;

import java.util.Date;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 考勤基点
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称

 */
@Data
public class KaoqinjidianModel  implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 基点名称
	 */

	private String jidianmingcheng;

	/**
	 * 基点地址
	 */

	private String jidiandizhi;

	/**
	 * 时间点
	 */

	private String shijiandian;

	/**
	 * 基点详情
	 */

	private String jidianxiangqing;

	/**
	 * 最近点击时间
	 */

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date clicktime;

	/**
	 * 点击次数
	 */

	private Integer clicknum;

}
