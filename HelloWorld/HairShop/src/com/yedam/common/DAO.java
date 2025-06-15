package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//데이터 베이스의 연결정보를 활용해서 세션획득
public class DAO {
	String url = "jdbc:oracle:thin:@192.168.0.22:1521:xe";
	String id = "scott2";
	String pass = "tiger";
	// connection 생성하는 메소드
	Connection conn;
    Statement stmt;
    ResultSet rs;
    PreparedStatement psmt;
	public void  getConnect() {
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url, id, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {if(conn!=null)conn.close();
		if(stmt!=null) stmt.close();
		if(rs != null) rs.close();
			
		}catch(SQLException e) {
			
		}
	}
	
	
}
