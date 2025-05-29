package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 1 driver manager
//2 connection
//3. statement
//4. 실행
//5. resultset
//6. 출력
public class DatabaseExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pass = "tiger";
		// 세션
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn = DriverManager.getConnection(url, id, pass);
				conn.setAutoCommit(false);//자동커밋 끄기
				System.out.println("연결성공");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결");
		}
		// statement 객체
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "update product set p_price=2000 where p_code= 201";
//		insert into product(p_code, p_name,p_price)
//		VALUES(200,'감자칩',2000);
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert,update,delete 할때 씀
			if (r > 0) {
				conn.commit();
				System.out.println(r + "등록이 되었습니다.");
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		try {
			rs = stmt.executeQuery("select * from product");
			System.out.println("상품코드 상품이름 	 가격");
			System.out.println("--------------------");

			while (rs.next()) {
				System.out.println(rs.getInt("p_code") + " "//
						+ rs.getString("p_name") + " " + rs.getInt("p_price"));
			}
			System.out.println("--------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// main
}
