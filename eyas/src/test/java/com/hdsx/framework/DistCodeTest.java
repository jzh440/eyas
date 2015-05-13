package com.hdsx.framework;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdsx.framework.author.bean.DistCode;
import com.hdsx.framework.author.mapper.orcl.DistCodeMapper;

/**
 * Unit test for simple App.
 */
public class DistCodeTest{
	private static ApplicationContext act;
	public DistCodeMapper mapper =(DistCodeMapper) act.getBean("distCodeMapper");
	@BeforeClass
	public static void setup(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testSelect(){
		DistCode discode = new DistCode();
		discode.setCode("3601");
		DistCode selectOne = mapper.selectOne(discode);
		System.out.println(selectOne);
		}
}
