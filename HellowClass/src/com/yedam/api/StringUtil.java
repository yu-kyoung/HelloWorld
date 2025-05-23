package com.yedam.api;

import java.io.File;

public class StringUtil {

	public static String getGender(String date) {
		int pos =-1;
		pos=date.length()-7; // 14-7
		
		char gNo=date.charAt(pos);
		  
		
		
		
		String second=date.substring(date.length()-7,date.length()-6);
		int ch=second.indexOf(1);
		System.out.println(second);
		if(ch%2==1) {
		}else if(ch%2==0) {
		}
		return second;
		
		
		
	}

//	public static String getExtName(String date) {
		
		//lastindexOf 뒤에서 부터 찾아옴
//		substring(File.indexOf("."));
		
		
	}





//getExtName