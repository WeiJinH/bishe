package com.huangbishe.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
public class YuangongchuchaiModel implements Serializable {
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
}
