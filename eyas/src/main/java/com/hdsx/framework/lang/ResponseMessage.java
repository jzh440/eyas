package com.hdsx.framework.lang;

import java.io.Serializable;

/**
 * ResponseMessage返回信息类
 * @author jingzh
 *
 * @param 
 */
public class ResponseMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 请求失败
	 */
	public static boolean STATUS_ERROR = false;
	/**
	 * 请求成功
	 */
	public static boolean STATUS_SUCESS = true;

	private int errCode;
	private boolean status;
	private Object message;
	public ResponseMessage(){
	}
	public ResponseMessage(Object message){
		this.message=message;
	}
	
	public ResponseMessage(boolean status,Object message){
		this.status=status;
		this.message=message;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	
}
