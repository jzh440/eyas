package com.hdsx.framework.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.hdsx.framework.lang.ResponseMessage;
import com.hdsx.framework.util.JsonUtils;

public abstract class BaseController {

	protected Log log=LogFactory.getLog(BaseController.class);
	@Resource
	protected HttpServletRequest request;
	@Resource
	protected HttpServletResponse response;
	/**
	 * 响应内容
	 */
	protected ResponseMessage message =  new ResponseMessage(); 
	/**
	 * 注册数据类型处理器
	 * @param binder
	 */
	@InitBinder    
	protected void initBinder(WebDataBinder binder) {    
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));    
		binder.registerCustomEditor(int.class, new CustomNumberEditor(Integer.class, true));    
	    binder.registerCustomEditor(long.class, new CustomNumberEditor(Long.class, true));  
	    binder.registerCustomEditor(float.class, new CustomNumberEditor(Float.class, true)); 
	    binder.registerCustomEditor(double.class, new CustomNumberEditor(Double.class, true));
	    binder.registerCustomEditor(List.class, new CustomCollectionEditor(ArrayList.class));
	} 
	/**
	 * 输出json数据
	 * @param message
	 */
	protected void write(){
		try 
		{
			response.reset();
			response.setContentType("text/javascript;charset=UTF-8");
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
     * 异常处理器异常
     * Exception Type:1、参数传递异常 2、业务逻辑处理异常
     * @param exception 
     * @return 
     */  
    @ExceptionHandler  
    public void RuntimeExceptionHandler(Throwable e) throws Throwable{  
    	log.error(e.getMessage(), e.getCause());
    	throw new Throwable(e);
    }  
    /**
     * 数据复原，清空
     */
    protected void clear(){
		message = new ResponseMessage();
    }
    
    /**
     * 获取配置参数
     * @param name
     * @return
     */
    protected String getParameter(String name){
    	return request.getParameter(name);
    }
}
