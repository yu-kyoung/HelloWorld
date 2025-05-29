package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		//set 컬렉션
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("월요일");
		set.add("금요일");

		
		//삭제,조회
		if(set.contains("홍길동")){
		System.out.println(set.remove("홍길동"));
		}
		//추가 add 삭제 remove
		
		//반복
		Iterator<String> iter=set.iterator();//반복자획득/
		while(iter.hasNext()) {//반복요소의 여부체크  하나씩 가지고 와서 체크
			String result =iter.next();
			System.out.println(result);
		}
		
	}
}
