package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//객체 입출력 스트림
public class StreamExe4 {
//기본타입 -참조타입
//int num=10;  member member =new member();
//객체를 기본타입으로 변경- 직렬화	
//Serializable 인터페이스 구현 클래스
//역직렬허 기본 ->객체
	class Product implements Serializable {
		String prodCode;

		public Product(String prodCode) {
			this.prodCode = prodCode;
		}
	}

	public static void main(String[] args) {
	
	try {
		InputStream is = new FileInputStream("c:/temp/object.db");
		ObjectInputStream ois = new ObjectInputStream(is);

		List<Product>list = (List <Product>) ois.readObject();
		for(Product product :list) {
			System.out.println("상품코드: "+ product.prodCode);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
		
		
		
		
	}
	 void serial() {
		List<Product> list = new ArrayList<>();

		list.add(new Product("P001"));
		list.add(new Product("P002"));

		try {
			OutputStream os = new FileOutputStream("c:/temp/object.db");
			ObjectOutputStream oos = new ObjectOutputStream(os);

			oos.writeObject(list);
			oos.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
	
	
	
}
