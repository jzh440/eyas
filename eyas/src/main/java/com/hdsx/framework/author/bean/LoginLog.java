package com.hdsx.framework.author.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 登录日记
 * @author xiongxt
 * @2015年3月29日 上午12:25:11
 */
public class LoginLog implements Serializable{
	/**登录异常*/
	public static final String RESULT_LOGIN_EXCEPTION = "0";
	/**登录成功*/
	public static final String RESULT_LOGIN_SUCCESS = "1";
	/**登录错误*/
	public static final String RESULT_LOGIN_ERROR = "2";
	/**解锁*/
	public static final String RESULT_LOGIN_UNLOCK = "3";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 登录名称 */
	private String userName;
	/** 登录时间 */
	private Date time;
	/** 登录结果 0：异常  1：成功  2： 失败 3：解锁*/
	private String result;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public LoginLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginLog(String userName, Date time, String result) {
		super();
		this.userName = userName;
		this.time = time;
		this.result = result;
	}
	@Override
	public String toString() {
		return "LoginLog [userName=" + userName + ", time=" + time
				+ ", result=" + result + "]";
	}
}
