package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {

	long now=System.currentTimeMillis();//현재 시간을 1/1000초 단위로  표현
	System.out.println(now);
	//1747964891 3600 초 => 몇일, 몇시간, 몇분,몇초
	//60*60*24
	long time=1747966191;
	long year=time/(60*60*24*365);
	long day=time/(60*60*24);
	long h=time/(60*60);
	long m=time/60;
	System.out.printf("%d년 %d일, %d시 ,%d분",year ,day ,h ,m);
	
	
	}
	
	
	public static void exe() {
	
	//현재시가늘 정 수로 반환
	long start = System.nanoTime();//System.currentTimeMillis();
	int sum =0;
	for(int i=0;i<100000000; i++) 
	{
		sum+=i;
	}
	long end = System.nanoTime();
	System.out.printf("합계 %d, 걸린시간 %d\n", sum,(end-start));
	
	}
}
