package com.huangbishe.entity.vo;

import java.util.Date;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 员工考勤
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 */
@Data
public class YuangongkaoqinVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 部门
	 */
	
	private String bumen;
		
	/**
	 * 类型
	 */
	
	private String leixing;
		
	/**
	 * 考勤基点
	 */
	
	private String kaoqinjidian;
		
	/**
	 * 考勤时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date kaoqinshijian;

			
}
