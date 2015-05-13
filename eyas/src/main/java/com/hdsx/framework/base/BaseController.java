package com.hdsx.framework.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.hdsx.framework.author.bean.User;
import com.hdsx.framework.lang.ResponseMessage;
import com.hdsx.framework.util.JsonUtils;

public abstract class BaseController {

	private Log log=LogFactory.getLog(BaseController.class);
	@Resource
	protected HttpServletRequest request;
	@Resource
	protected HttpServletResponse response;
	/**
	 * 存储参数
	 */
	protected Map<String, Object> param = new HashMap<String, Object>();
	/**
	 * 响应内容
	 */
	protected ResponseMessage message =  new ResponseMessage(); 
	/**
	 * 输出json数据
	 * @param message
	 */
	protected void write(){
		try 
		{
			response.reset();
			response.setContentType("text/javascript;charset=UTF-8");
			message.setStatus(ResponseMessage.STATUS_SUCESS);
			JsonUtils.write(message, response.getWriter());
		} catch (IOException e) {
			log.error(e.getMessage(), e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			log.error(e.getMessage(), e.getCause());
			e.printStackTrace();
		} finally {
			clear(); 
		}
	}
	/** 
     * 运行时异常处理器
     * @param exception 
     * @return 
     */  
    @ExceptionHandler(RuntimeException.class)  
    public void exceptionHandler(Exception e) {  
    	try {
			log.error(e.getMessage(),e.getCause());  
			response.reset();
			response.setContentType("text/javascript;charset=UTF-8");
			message.setStatus(ResponseMessage.STATUS_BAD_REQUEST);
			message.setMessage(e.getMessage());
			JsonUtils.write(message, response.getWriter());
		}catch (Exception e1){
			log.error(e1.getMessage(), e1.getCause());
			e1.printStackTrace();
		}finally{
			clear();
		}
    }  
    /**
     * 获取当前登录用户
     * @return
     */
    protected User loginUser(){
    	User user = null;
		try {
			Object o = request.getSession(false).getAttribute("loginuser");
			if(o != null) {
				user = (User)o;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("----------------未登录-----------------");
		}
    	return user;
    }
    /**
     * 获取当前登录用户单位
     * @return
     */
    protected String getDeptId(){
	    User loginUser = loginUser();
		String deptId = null;
		
		if(loginUser !=null){
		    deptId = loginUser.getDeptId();
		}
		return deptId;
    }
    /**
     * 数据复原，清空
     */
    protected void clear(){
    	param.clear();
		message = new ResponseMessage();
    }
    
    /**
     * 获取配置参数
     * @param name
     * @return
     */
    protected String getInitParameter(String name){
    	return request.getServletContext().getInitParameter(name);
    }
}
