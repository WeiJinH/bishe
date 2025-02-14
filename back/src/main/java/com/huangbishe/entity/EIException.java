
package com.huangbishe.entity;

import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class EIException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public EIException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public EIException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public EIException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public EIException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	
}
