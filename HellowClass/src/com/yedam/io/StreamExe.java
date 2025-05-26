package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {
	public static void main(String[] args) {
//original.PNG -> copy2.PNG
		try {
			InputStream is =new FileInputStream("c:/temp/original.PNG");
			OutputStream os = new FileOutputStream("c:/temp/copy2.PNG");
		//보조 스트림에 연결
			BufferedInputStream bis= new BufferedInputStream(is);
			BufferedOutputStream bos= new BufferedOutputStream(os);
			//읽기 -쓰기 
		while(true) {
			int data= bis.read();
			if(data==-1) {
				break;
			}
			bos.write(data);
		}
			bos.close();
			bis.close();
			os.close();
			is.close();//호출한 역순으로 클로즈
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("end of prog");
	}//main

	
	
	public static void copy() {
		//입력=>출력
				try {
					// 입력 스트림 jpg
					InputStream is = new FileInputStream("c:/temp/original.PNG");
					// 출력스트림(copy.jpg)
					OutputStream os = new FileOutputStream("c:/temp/copy.PNG");
					//한번에 읽기쓰기 byte[]만큼한번에 처리
					byte[]buf=new byte[10];
					
					long start= System.currentTimeMillis();//시작시간
					while (true) {
						int data = is.read(buf);// 읽기
						if (data == -1) {
							break;
						}
						os.write(buf);// 쓰기
					}
					os.close();
					is.close();
					long end=System.currentTimeMillis();//종료시간
					System.out.println("걸린시간: "+(end-start));
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("end of prog");
	}//copy
	
	
	public static void read() {

		// 입력(파일)=바이트 기반
		try {
			InputStream is = new FileInputStream("c:/temp/os1.db");
			// read() 1바이트씩 읽기 -1 반환 (파일 끝까지 오면)
			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				System.out.println(data);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void write() {
		// 출력(파일)=바이트 기반
		try {
			OutputStream os = new FileOutputStream("c:/temp/os1.db");
			byte b1 = 10;
			byte b2 = 20;
			byte b3 = 30;
			os.write(b1);
			os.write(b2);
			os.write(b3);
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
}
