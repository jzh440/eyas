package com.hdsx.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;


public class ProtocolFilter implements Filter {
	/**
	 * 数据返回格式 1：JSON 2：XML 默认1
	 */
	public static final int DATA_FORMAT_TYPE_JSON=1;
	
	public static final int DATA_FORMAT_TYPE_XML=2;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		afterCallBack((HttpServletRequest)request,(HttpServletResponse)response);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	/**
	 * 判断客户端是否支持GZIP或者需要GZIP格式的数据
	 * @param req
	 * @return
	 */
	protected boolean isGzipSupported(HttpServletRequest req) {  
		String browserEncodings = req.getHeader("Accept-Encoding");  
		return (browserEncodings != null) && (browserEncodings.indexOf("gzip") != -1);  
	} 
	protected void afterCallBack(HttpServletRequest request,HttpServletResponse response){
		String dataFormatType=request.getParameter("dataFormatType");
		//String dataCallback=request.getParameter("dataCallback");
		String charSet=request.getParameter("charset");
		String dataMediaType=MediaType.ALL_VALUE;
		if(dataFormatType==null){
			dataFormatType=String.valueOf(DATA_FORMAT_TYPE_JSON);
		}
		if(charSet==null){
			charSet="UTF-8";
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType(dataMediaType+";charset="+charSet+"");
	}

}
