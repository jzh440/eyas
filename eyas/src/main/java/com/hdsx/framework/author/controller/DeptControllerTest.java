package com.hdsx.framework.author.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hdsx.framework.author.bean.Dept;
import com.hdsx.framework.author.service.DeptService;

//spring mvc处理方法支持如下的返回方式：
//ModelAndView, Model, ModelMap, Map,View, String, void
//@SessionAttributes 只能声明在类上，而不能声明在方法上。 
//@SessionAttributes("currUser") // 将ModelMap 中属性名为currUser 的属性 
//@SessionAttributes({"attr1","attr2"}) 
//@SessionAttributes(types = User.class) 
//@SessionAttributes(types = {User.class,Dept.class}) 
//@SessionAttributes(types = {User.class,Dept.class},value={"attr1","attr2"}) 

//@Controller
//@Controller("deptController")
@RequestMapping("/test")
public class DeptControllerTest {
		@Resource
		private DeptService deptSerivce;

		@RequestMapping("/register.do")
		public String register() {
			return "/register";
		}
//		@RequestMapping(value={"",""},method ={"",""},headers={},params={"",""})
		@RequestMapping(
//				switch 1:
				value={"/get/{id}","/get/123435"},
//				switch 2:
				method = {RequestMethod.POST,RequestMethod.GET},headers={},
//				switch 3:
				params="method=createUser")
		public ModelAndView createUser(Dept dept) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("sucess");
			mav.addObject("dept", dept);
			return mav;
		}
		//1.有返回值的方法，添加返回值到作用域,用户页面使用---request.setAttribute(,) 
		//2.应用于方法参数,参数可以在页面直接获取,须关联到Object的数据类型.基本数据类型 如：int,String不起作用 
		@ModelAttribute("items")
//		@PathVariable用于地址栏使用{xxx}模版变量时使用
		@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
		public String findOwner(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day,@PathVariable/*("id")*/ String id, Model model,@ModelAttribute("createDept")Dept createDept) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			Dept dept = deptSerivce.selectOne(param);
			model.addAttribute("dept", dept);
			return "displayOwner";
		}
//		@ResponseBody
		/*通过使用 @ModelAttribute 注解，populateItem() 方法将在
		任何请求处理方法执行前调用，Spring MVC 会将该方法返回值以“items
		”为名放入到隐含的模型对象属性列表中。 
		所以在 ② 处，我们就可以通过 ModelMap 入参访问到 items 属性，当执
		行 listAllBoard() 请求处理方法时，② 处将在控制台打印
		出“model.items:2”的信息。当然我们也可以在请求的视图中访问到模型
		对象中的 items 属性。 */
		@ModelAttribute("items")//<——①向模型对象中添加一个名为items的属性  
		public List<String> populateItems() {  
		        List<String> lists = new ArrayList<String>();  
		        lists.add("item1");  
		        lists.add("item2");  
		        return lists;  
		}  
		@SuppressWarnings("unchecked")
		@RequestMapping(params = "method=listAllBoard"/*,consumes="text/plain;charset=ISO8859-1,text/plain;charset=UTF-8"*/)  
		public String listAllBoard(@ModelAttribute("currDept")Dept dept,ModelMap model) {  
//		        bbtForumService.getAllBoard();  
		        //<——②在此访问模型中的items属性  
		        System.out.println("model.items:" + ((List<String>)model.get("items")).size());  
		        return "listBoard";  
		}  
//		@RequestParam(value="a", required=false)
//		@ModelAttribute( " pojo " ) Pojo pojo
//		@PathVariable String id
//		@RequestBody绑定请求对象，Spring会帮你进行协议转换，将Json、Xml协议转换成你需要的对象。
//		@ResponseBody可以标注任何对象，由Srping完成对象——协议的转换。
//	@ResponseBody 
//	这个注解可以直接放在方法上，表示返回类型将会直接作为HTTP响应字节流输出(不被放置在Model，也不被拦截为视图页面名称)。可以用于ajax。
		@RequestMapping(value = "/upload.do"/*,consumes="application/json;charset=UTF-8",produces="application/json;charset=UTF-8"*/)  
	    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
	  
	        System.out.println("开始");  
	        String path = request.getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename();  
//	        String fileName = new Date().getTime()+".jpg";  
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
	  
	        return "result";  
	    }  	

//		@RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\d\.\d\.\d}.{extension:\.[a-z]}")  
//		  public void handle(@PathVariable String version, @PathVariable String extension) {      
//		    // ...  
//		  } 


}
