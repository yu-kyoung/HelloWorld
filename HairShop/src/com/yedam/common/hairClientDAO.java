package com.yedam.common;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.HairShop;



public class hairClientDAO extends DAO {

	public int insert(HairShop client) {

		String sql = "insert into hair_product(product,price,des)"//
				+ "values(?,?,?)";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, client.getProduct());
			psmt.setInt(2, client.getPrice());
			psmt.setString(3, client.getDes());

			int r = psmt.executeUpdate();
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return 0;
	}// insert end

	public int update(HairShop client) {
		String sql = "update hair_product"//
				+ " set price =?"//
				+ ",des=?"//
				+ " where product=?";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, client.getPrice());
			psmt.setString(2, client.getDes());
			psmt.setString(3, client.getProduct());
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return 0;

	}

	public int delete(String product) {
		String sql = "delete from hair_product"//
				+ " where product=?";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product);
		
			int r = psmt.executeUpdate();
			return r; // 건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return 0;
		
	}
	
	public List<HairShop> select() {
		String sql = "select * from hair_product";
		
		List<HairShop>list = new ArrayList<>();
		getConnect();
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();//조회
			while(rs.next()) {
			HairShop cl= new HairShop();
			cl.setMemberId(rs.getString("member_id"));
			cl.setMemberName(rs.getString("member_name"));
			cl.setPhone(rs.getString("phone"));
		
			
			list.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return list;
		
		
		return null;
	}
	
}
