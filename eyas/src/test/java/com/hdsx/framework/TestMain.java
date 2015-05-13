package com.hdsx.framework;

public class TestMain {
	public static void main(String[] args) {
		System.out.println(set());
	}
	
	public static String set()	{
		String result = "1";
		try {
			System.out.println("try");
			result = "2";
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch");
			result = "3";
			return result;
		} finally{
			System.out.println("finally");
			result = "4";
		}
	}
	
}
