package com.yedam.api;

import java.lang.reflect.Field;

import com.sun.jdi.Method;

public class ClassExe {
	
	try {
	Class cls= Class.forName("com.yedam.api.Member");
	Member member=new Member();
	cls= member.getClass();
	System.out.println(cls.getName());
	Field[] fieldAry =cls.getDeclaredFields();
	for(Field field : fieldAry) {
	System.out.println(field.getName());
	}
	
	Method[] methodAry = cls.getDeclaredMethods();
	for(Method method:methodAry) {}
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	
}
	
	
