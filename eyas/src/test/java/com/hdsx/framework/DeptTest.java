package com.hdsx.framework;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdsx.framework.author.bean.Dept;
import com.hdsx.framework.author.mapper.orcl.DeptMapper;
import com.hdsx.framework.author.service.DeptService;
import com.hdsx.framework.util.UUIDUtil;

/**
 * Unit test for simple App.
 */
public class DeptTest{
	private static ApplicationContext act;
	private DeptMapper mapper =(DeptMapper) act.getBean("deptMapper");
	private DeptService service =(DeptService) act.getBean("deptServiceImpl");
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		act=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test//异常 index in或out参数10
	public void testMapperInsert(){
		Dept d =  new Dept();
		d.setId(UUIDUtil.getID());
		d.setDeptName("次数据");
		d.setDistCode("360124");
		d.setAddress("海淀区12");
		d.setTel("010-2342234");
		d.setFax("010-342342");
		d.setPid(null);
		d.setPostCode("330821");
		d.setLeader("米子123");
		int rs = mapper.insert(d);
		System.out.println(rs);
	}
	@Test
	public void testServiceInsert(){
		
		for(int i = 1000; i < 10020;i++){
			Dept d =  new Dept();
			d.setId(UUIDUtil.getID());
			d.setDeptName("第"+i+"次数据");
			d.setDistCode("360124");
			d.setAddress("海淀区"+i);
			d.setTel("010-2342234");
			d.setFax("010-342342");
			d.setPid(null);
			d.setPostCode("330821");
			d.setLeader("米子"+i);
			int rs = service.insert(d);
			System.out.println(rs);
		}
	}
		@Test
		public void testServiceSelect(){
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("id", "467ed3a9726b4842ab307b0550871b03");
				Dept selectOne = service.selectOne(param);
				System.out.println(selectOne);
		}
}
