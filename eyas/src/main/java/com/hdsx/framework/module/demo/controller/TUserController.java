package com.hdsx.framework.module.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hdsx.framework.base.BaseController;
import com.hdsx.framework.module.demo.bean.TUser;
import com.hdsx.framework.module.demo.service.TUserService;

//@Controller
@RequestMapping(value="user")
public class TUserController extends BaseController{

//	@Resource
	private TUserService userService;
//	@ResponseBody
	@RequestMapping(value="queryUsers.do",method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
//	@ExceptionHandler(Exception.class)
	public void queryUsers(){
//		try 
//		{
			List<TUser> users=userService.selectList();
			message.setStatus(true);
			message.setMessage(users);
//		} catch (Exception e) {
//			message.setStatus(false);
//			message.setMessage(e.getMessage());
//			e.printStackTrace();
//		}
//		finally
//		{
			write();
//		}
		
	}
	@ResponseBody
	@RequestMapping(value="queryUser.do",method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	public void queryUser(@RequestParam(value="id") String id){
		try 
		{
//			String str1=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
			List<TUser> users=userService.selectList();
			message.setStatus(true);
			message.setMessage(users);
		} catch (Exception e) {
			message.setStatus(false);
			message.setMessage(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			write();
		}
		
	}
	@ResponseBody
	@RequestMapping(value="addUser.do",method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	public void addUser(@ModelAttribute(value="TUser") TUser user){
		try 
		{
			System.out.println(user.getId());
			List<TUser> users=userService.selectList();
			message.setStatus(true);
			message.setMessage(users);
		} catch (Exception e) {
			message.setStatus(false);
			message.setMessage(e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			write();
		}
		
	}
	@RequestMapping(value="/{uri}",method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public void addView(@PathVariable String uri){
		try 
		{
			 response.sendRedirect(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
