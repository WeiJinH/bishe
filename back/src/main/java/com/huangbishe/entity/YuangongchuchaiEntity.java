package com.huangbishe.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@Data
@TableName("yuangongchuchai")
public class YuangongchuchaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public YuangongchuchaiEntity() {

    }

    public YuangongchuchaiEntity(T t) {
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
     * 员工姓名
     */

    private String yuangongxingming;

    /**
     * 部门
     */

    private String bumen;

    /**
     * 出差时间
     */

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date chuchaishijian;

    /**
     * 出差天数
     */

    private Integer chuchaitianshu;

    /**
     * 出差方式
     */

    private String chuchaifangshi;

    /**
     * 出差原因
     */

    private String chuchaiyuanyin;

    /**
     * 是否审核
     */

    private String sfsh;

    /**
     * 审核回复
     */

    private String shhf;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;
}
