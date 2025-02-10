package com.huangbishe.entity.vo;

import java.util.Date;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 考勤基点
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 */
@Data
public class KaoqinjidianVO  implements Serializable {
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				

			
}
