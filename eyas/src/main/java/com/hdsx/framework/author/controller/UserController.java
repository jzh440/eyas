/*package com.hdsx.framework.author.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hdsx.framework.author.bean.LoginLog;
import com.hdsx.framework.author.bean.User;
import com.hdsx.framework.author.service.UserService;
import com.hdsx.framework.base.BaseController;
import com.hdsx.framework.lang.UIPage;
import com.hdsx.framework.util.ExcelExport;
import com.hdsx.framework.util.Iso2UtfUtil;
import com.hdsx.framework.util.MD5Util;
import com.hdsx.framework.util.StringUtile;
*//**
 * 用户控制器
 * @author xiongxt
 * @2015年3月21日
 *//*
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private UserService service;
	
	*//**
	 * 根据id查询用户
	 * @param id
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="get/{id}",method=RequestMethod.GET)
	public void selectOne(@PathVariable("id")String id){
		if(StringUtile.isEmptyString(id)){
			//User loginUser = loginUser();
		//message.setMessage(loginUser);
		}else{
		//param.put("id", id);
		//User bean = service.selectOne(param);
		//.setMessage(bean);
		}
		write();
	}
	
	*//**
	 * 根据id查询用户
	 * @param id
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="info/{id}",method=RequestMethod.GET)
	public void selectById(@PathVariable("id") String id) {
		if (StringUtile.isEmptyString(id)) {
			//User loginUser = loginUser();
			//message.setMessage(loginUser);
		} else {
			//User bean = service.selectById(id);
			//message.setMessage(bean);
		}
		write();
	}

	*//**
	 * 增加用户
	 * @param id
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="add",method=RequestMethod.POST)
	public void insert(@ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:sss") User user){
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		int result = service.insert(user);
		message.setMessage(result);
		write();
	}
	
	*//**
	 * 根据id修改用户
	 * @param id
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="modify",method=RequestMethod.POST)
	public void update(@ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:sss") User user){
		int result = service.update(user);
		message.setMessage(result);
		write();
	}
	
	*//**
	 * 根据ids删除用户
	 * @param ids
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="remove",method=RequestMethod.POST)
	public void delete(@RequestParam String ids){
		String[] ids_ = null;
		if(!StringUtile.isEmptyString(ids)) {
			ids_ = ids.replaceAll(" ", "").split(",");
		}
		param.put("ids", ids_);
		int result = service.delete(param);
		message.setMessage(result);
		write();
	}
	
	*//**
	 * 分页查询
	 * @param order 排序sql语句
	 * @param page  第几页
	 * @param rows  每页数
	 * @param user  查询条件
	 * @throws UnsupportedEncodingException 
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="query",method=RequestMethod.GET)
	public void selectList(@RequestParam(defaultValue="USERNAME DESC",required=false) String order,@RequestParam(defaultValue="0",required=false) int page, @RequestParam(defaultValue="0",required=false) int rows, @ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd") User user) throws UnsupportedEncodingException{
		UIPage<User> uipage = new UIPage<User>(page, rows);
		Iso2UtfUtil.converToUTF(user);
		param = uipage.getParameter();//put begin和end
		param.put("userName", user.getUserName());
		param.put("mobile", user.getMobile());
		param.put("email", user.getEmail());
		param.put("order", order);//排序
		List<User> results = service.selectList(param);
		int total = service.count(param);
		uipage.setRows(results);
		uipage.setTotal(total);
		message.setMessage(uipage);
		write();
	}
	
	*//**
	 * 导出
	 * @param order 排序sql语句
	 * @param user  查询条件
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="export",method=RequestMethod.GET)
	public void export(@RequestParam(defaultValue="USERNAME",required=false) String order, @RequestParam(required=false) String ids, 
			@ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd") User user){
		param.put("order", order);//排序
		if (!StringUtile.isEmptyString(ids)) {
			String[] ids_ = ids.replace(" ", "").split(",");
			param.put("ids", ids_);
		} else {
			Iso2UtfUtil.converToUTF(user);//查询条件转码成UTF-8
			param.put("userName", user.getUserName());
			param.put("mobile", user.getMobile());
			param.put("email", user.getEmail());
		}
		List<User> list = service.selectList(param);
		String[] codes={"userName", "realName", "post", "mobile", "email", "deptName"};
		String[] names={"登录名称", "真实姓名", "联系地址", "手机", "电子邮箱", "单位名称"};
		HSSFWorkbook export = ExcelExport.export(names, codes, "yyyy年MM月dd日", list);
		try {
			ExcelExport.exportExcel(response, export, "用户");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			clear();
		}
	}
	
	*//**
	 * 用户登出
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="logout",method=RequestMethod.POST)
	public void logout(){
		HttpSession session = request.getSession();
		session.removeAttribute("loginuser");
		session.invalidate();
		write();
	}
	
	*//**
	 * 修改密码
	 * @param newpassword 新密码
	 * @param user 登录名称和原始密码
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="reset",method=RequestMethod.POST)
	public void reset(@RequestParam String newpassword, @ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:sss") User user){
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		param.put("userName", user.getUserName());
		User old = service.selectOne(param);
		if(old != null){
			if(old.getPassword().equals(user.getPassword())){
				old.setPassword(MD5Util.encrypt(newpassword));
				int result = service.update(old);
				message.setMessage(result);
			} else {
				String message = "输入的登录名称或者原始密码错误！";//不准确的提示（实际是登录密码错误）
				throw new RuntimeException(message);
			}
		}else{
			String message = "输入的登录名称或者原始密码错误！";//不准确的提示（实际是登录名称不存在）
			throw new RuntimeException(message);
		}
		write();
	}
	
	*//**
	 * 解锁并重置密码,重置为111111
	 * @param id 要重置的用户
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="reset/{id}",method=RequestMethod.POST)
	public void reset(@PathVariable String id){
		User old = service.selectById(id);
		if(old != null){
			int unlock = Integer.parseInt(getParameter("unlock"));
		    Date lastUnlock = service.lastUnlock(old.getUserName());
			if(lastUnlock == null || (new Date().getTime() - lastUnlock.getTime() > unlock*24*60*60*1000)){
				//解锁
			    service.insertLog(new LoginLog(old.getUserName(),new Date(),LoginLog.RESULT_LOGIN_UNLOCK));
				//重置
			    old.setPassword(MD5Util.encrypt("111111"));
				int result = service.update(old);
				message.setMessage(result);
		    }else{
		    	String message = unlock + "天内只能解锁一次！";
		    	throw new RuntimeException(message);
		    }
		}else{
			String message = "用户不存在！";
			throw new RuntimeException(message);
		}
		write();
	}
	
	*//**
	 * 用户登录
	 * 
	 * @param user
	 *//*
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(@ModelAttribute User user) {
		// 0: 异常日记 1:成功日记 2:错误日记 3:解锁日记
		String result = LoginLog.RESULT_LOGIN_ERROR;
		// 是否记录登录失败的日记（不记录）
		boolean log = false;
		try {
			Iso2UtfUtil.converToUTF(user);

			String lock = getParameter("lock");
			// 间隔毫秒数
			int hour = Integer.parseInt(getParameter("time"));
			int time = hour * 60 * 60 * 1000;
			int max_error = Integer.parseInt(getParameter("error"));
			param.put("lock", lock);
			param.put("time", time);
			param.put("userName", user.getUserName());

			int error = service.error(param);

			if (error < max_error) {
				User login1 = service.selectOne(param);
				if (login1 == null || StringUtile.isEmptyString(login1.getId())) {
					String message = "登录名称错误！";
					throw new RuntimeException(message);
				} else {
					User login2 = null;
					try {
						param.put("password", MD5Util.encrypt(user.getPassword()));
						login2 = service.selectOne(param);
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						String message = "登录过程中异常！";
						result = LoginLog.RESULT_LOGIN_EXCEPTION;
						log = true;
						throw new RuntimeException(message);
					}
					if (login2 == null
							|| StringUtile.isEmptyString(login2.getId())) {
						String message;
						if (error + 1 == max_error) {
							message = "1".equals(lock) ? "密码不正确，账号被锁定，请隔天尝试登录！"
									: "密码不正确，账号被锁定，请稍后尝试！";
						} else {
							message = "密码不正确，再错误" + (max_error - error - 1)
									+ "次后将锁定账号！";
						}
						result = LoginLog.RESULT_LOGIN_ERROR;
						log = true;
						throw new RuntimeException(message);
					} else {
						result = LoginLog.RESULT_LOGIN_SUCCESS;
						message.setMessage(login2);
						// 成功日记
						service.insertLog(new LoginLog(user.getUserName(),
								new Date(), result));
						if(!MD5Util.encrypt("111111").equals(login2.getPassword())){
							request.getSession().setAttribute("loginuser", login2);
						} else {
							String message = "重置密码后，需要修改密码才能继续操作!";
							try {
								response.sendRedirect("/eyas/reset.jsp?message="+message);
								return;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			} else {
				String message = "1".equals(lock) ? "今天已经连续错误超过" + max_error
						+ "次，账号已经被锁定，请隔天尝试登录！" : hour + "小时内连续错误超过" + max_error
						+ "次，账号已经被锁定，请稍后尝试！";

				throw new RuntimeException(message);
			}
		} catch (RuntimeException e) {
			if (log) {
				// 失败或者异常日记
				service.insertLog(new LoginLog(user.getUserName(), new Date(),
						result));
			}
			throw e;
		}
		write();
	}
}
*/