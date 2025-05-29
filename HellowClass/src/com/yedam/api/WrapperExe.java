package com.yedam.api;

public class WrapperExe {
	public static void main(String[] args) {
		int num = 10;
		Integer num2 = 20;// new Integer(20);//박싱과 언박싱
		num = num2.intValue();

		String str="10";
		num = Integer.parseInt(str);
		
		double num3= Double.parseDouble(str);//10.0
		num3=Float.parseFloat(str);//자동형변환
		
		Integer num4 = new Integer(10);// 기본타입=> 참조타입(박싱)
		Integer num5 =new Integer(10); // 참조타임 => 기본타입(언박싱)
		System.out.println(num4.intValue()==num5.intValue());
	}
}
