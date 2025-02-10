package com.huangbishe.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 员工
 * 数据库通用操作实体类（普通增删改查）
 */
@Data
@TableName("yuangong")
public class YuangongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuangongEntity() {
		
	}
	/**
	 * 将一个对象的属性复制到当前员工实体中
	 * 该构造函数用于对象之间的属性复制，主要利用Apache Commons BeanUtils库实现
	 *
	 * @param t 源对象，其属性将被复制到当前员工实体中
	 */
	public YuangongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 员工工号
	 */
					
	private String yuangonggonghao;
	
	/**
	 * 密码
	 */
	@JsonIgnore
	@TableField("mima")
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


	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;


}
