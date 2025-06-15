package com.yedam.common;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.yedam.vo.HairShop;

public class hairClientDAO extends DAO {

	public int insert(HairShop client) {// 상품등록

		String sql = "insert into hair_product(product,price,des)"//
				+ " values(?,?,?)";
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

	public int update(HairShop client) {// 상품수정
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

	}// update end

	public int delete(String product) {// 상품삭제
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

	}// delete end

	public List<HairShop> select() {// 상품조회
		String sql = "select * from hair_product";

		List<HairShop> list1 = new ArrayList<>();
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();// 조회
			while (rs.next()) {
				HairShop cl = new HairShop();
				cl.setProduct(rs.getString("product"));
				cl.setPrice(rs.getInt("price"));
				cl.setDes(rs.getString("des"));

				list1.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list1;

	}

	public int insert1(HairShop client) {// 고객등록

		String sql = "insert into hair_client" + "(client_id,client_name,phone,birth,rank1,pay)"
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

	public List<HairShop> select1() {// 고객조회
		String sql = "SELECT client_id, client_name, phone,TO_CHAR(birth, 'yy-MM-dd') as birth, rank1, pay, count FROM hair_client";

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
				cl.setCount(rs.getInt("count"));
				list.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}// select1 end

	public int update1(HairShop client) {// 고객수정
		String sql = "update hair_client" + " set client_name=?, phone=?, birth=?, pay=?, rank1=?"
				+ " where client_id=?";
		getConnect();
		try {
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

	}// update1 end

//월일 만 검색할 수 있게

	public List<HairShop> birth() {// 생일 이벤트 3일 전 알림
		String sql = "SELECT client_name, phone, TO_CHAR(birth, 'yy-MM-dd') as birth" + " FROM hair_client "
				+ "WHERE TO_CHAR(birth, 'MM-dd') = TO_CHAR(SYSDATE + 3, 'MM-dd')";
		List<HairShop> List = new ArrayList<>();
		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();// 조회
			while (rs.next()) {

				HairShop cl = new HairShop();
				cl.setClientName(rs.getString("client_name"));
				cl.setPhone(rs.getString("phone"));
				cl.setBirth(rs.getString("birth"));
				List.add(cl);
				// if (rs.getString("birth").equals(reDate)) {
				// }

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return List;

	}// birth end

	public int count(String phone) {//방문횟수 -NVL(count, 0)은 count가 NULL일 경우 0으로 처리
		String sql = "UPDATE hair_client SET count = count + 1 WHERE phone = ?";
		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	public int insert2(HairShop client) {// 예약고객등록

		String sql = "insert into reservation (reservation,client_name,phone,product,designer)" + " values(?,?,?,?,?)";
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
	}// insert2 end

	public List<HairShop> select2() {// 예약고객조회
		String sql = "SELECT reservation,client_name,phone,product,designer FROM reservation";

		List<HairShop> reList = new ArrayList<>();
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();// 조회
			while (rs.next()) {
				HairShop cl = new HairShop();
				cl.setReservation(rs.getString("reservation"));
				cl.setClientName(rs.getString("client_name"));
				cl.setPhone(rs.getString("phone"));
				cl.setProduct(rs.getString("product"));
				cl.setDesigner(rs.getString("designer"));

				reList.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reList;

	}// select1 end

	public int delete2(String client_name, String reservation) {// 상품삭제
		String sql = "delete from reservation"//
				+ " where client_name=? and reservation=? ";

		getConnect();
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, client_name);
			psmt.setString(2, reservation);

			int r = psmt.executeUpdate();
			return r; // 건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return 0;

	}// delete2 end
	
	
	public int delete3(String client_name, String phone) {// 
		String sql = "delete from hair_client"//
				+ " where client_name=? and phone=? ";

		getConnect();
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, client_name);
			psmt.setString(2, phone);

			int r = psmt.executeUpdate();
			return r; // 건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return 0;

	}// delete3 end
	

}
