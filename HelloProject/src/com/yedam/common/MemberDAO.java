package com.yedam.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Member;

//데이터 베이스에 ,,insert, update, delete, select
public class MemberDAO extends DAO {

	public int insert(Member member) {
		String sql = "insert into tbl_member(member_id, member_name, phone, point)"//
				+ "values(?,?,?,?)";

		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberId());
			psmt.setString(2, member.getMemberName());
			psmt.setString(3, member.getPhone());
			psmt.setInt(4, member.getPoint());
			// stmt=conn.createStatement();
			int r = psmt.executeUpdate();
			return r; // 건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;// 반영 안됨
	}// insert end

	public int update(Member member) {

		String sql = "update tbl_member"//
				+ "set phone =?"//
				+ ",point=?"//
				+ "where member_id=?";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPhone());
			psmt.setInt(2, member.getPoint());
			psmt.setString(3, member.getMemberId());
			// stmt=conn.createStatement();
			int r = psmt.executeUpdate();
			return r; // 건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;// 반영 안됨

	}//update end
	
	public int delete(String memberId) {
		String sql = "delete from tbl_member"//
					+ "where member_id=?";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberId());
		
			// stmt=conn.createStatement();
			int r = psmt.executeUpdate();
			return r; // 건수반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;// 반영 안됨
		
		
	}//delete end
	
	//목록
	public List<Member> select(){
		String sql ="select * from tbl_member";
		List<Member>list = new ArrayList<>();
		getConnect();
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();//조회
			while(rs.next()) {
			Member member= new Member();
			member.setMemberId(rs.getString("member_id"));
			member.setMemberName(rs.getString("member_name"));
			member.setPhone(rs.getString("phone"));
			member.setPoint(rs.getInt("point"));
			
			list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return list;
		}
		
	
}
