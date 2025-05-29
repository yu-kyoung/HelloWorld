package com.yedam.common;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

		List<HairShop> list = new ArrayList<>();
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();// 조회
			while (rs.next()) {
				HairShop cl = new HairShop();
				cl.setProduct(rs.getString("product"));
				cl.setPrice(rs.getInt("price"));
				cl.setDes(rs.getString("des"));

				list.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public int insert1(HairShop client) {// 고객등록

		String sql = "insert into hair_client" + "(client_id,client_name,phone,TO_CHAR(birth, 'YYYY-MM-DD'),rank1,pay)"
				+ "values(?,?,?,?,?,?)";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, client.getClientId());
			psmt.setString(2, client.getClientName());
			psmt.setString(3, client.getPhone());
			psmt.setString(4, client.getBirth());
			psmt.setString(5, client.getRank());
			psmt.setInt(6, client.getPay());

			int r = psmt.executeUpdate();
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return 0;
	}// insert1 end

	public List<HairShop> select1() {
		String sql = "SELECT client_id, client_name, phone, TO_CHAR(birth, 'yy-MM-dd') AS birth, rank1, pay "
				+ "FROM hair_client";

		List<HairShop> list = new ArrayList<>();
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();// 조회
			while (rs.next()) {
				HairShop cl = new HairShop();
				cl.setClientId(rs.getInt("client_id"));
				cl.setClientName(rs.getString("client_name"));
				cl.setPhone(rs.getString("phone"));
				cl.setBirth(rs.getString("birth"));
				cl.setRank(rs.getString("rank1"));
				cl.setPay(rs.getInt("pay"));

				list.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public int update1(HairShop client) {
		String sql = "update hair_client" + " set client_name=?, phone=?, birth=?, pay=?, rank1=?"
				+ " where client_id=?";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, client.getClientName());
			psmt.setString(2, client.getPhone());
			psmt.setString(3, client.getBirth());
			psmt.setInt(4, client.getPay());
			psmt.setString(5, client.getRank());
			psmt.setInt(6, client.getClientId());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return 0;

	}

//	String sql = "SELECT client_name,phone,birth" + " FROM hair_client"
//			+ " WHERE birth= TO_DATE(sysdate+3, 'yy-MM-dd')";
//월일 만 검색할 수 있게
	public List<HairShop> birth() {
		String sql = "SELECT client_name, phone, TO_CHAR(birth, 'yyyy-MM-dd') AS birth " + "FROM hair_client "
				+ "WHERE TO_CHAR(birth, 'MM-dd') = TO_CHAR(SYSDATE + 3, 'MM-dd')";
		List<HairShop> list1 = new ArrayList<>();
		getConnect();

//		String dateTyep = "MM-dd";// 날짜포맷
//		SimpleDateFormat dateFormat = //
//				new SimpleDateFormat(dateTyep);
//		Date now = new Date();
//		String today=dateFormat.format(now);//오늘날짜

//		Calendar cal = Calendar.getInstance();
//		cal.setTime(now);
//		cal.add(Calendar.DATE, 3);
//		String reDate = dateFormat.format(cal.getTime()); // 3일뒤 날짜

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();// 조회
			while (rs.next()) {

				HairShop cl = new HairShop();
				cl.setClientName(rs.getString("client_name"));
				cl.setPhone(rs.getString("phone"));
				cl.setBirth(rs.getString("birth"));
				list1.add(cl);
			//	if (rs.getString("birth").equals(reDate)) {
			//	}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list1;

	}

	public int insert2(HairShop client) {

		String sql = "insert into reservation" + "(reservation,client_name,phone,product,designer)"//
				+ "values(?,?,?,?,?)";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, client.getReservation());
			psmt.setString(2, client.getClientName());
			psmt.setString(3, client.getPhone());
			psmt.setString(4, client.getProduct());
			psmt.setString(5, client.getDesigner());

			int r = psmt.executeUpdate();
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return 0;
	}// insert end

}
