package com.yedam.vo;

//app-main,memberApp
//common DAO
//service (인터페이스 ,구현클래스)
//			-업무(입사절차) -사원.급여.근태
//vo(Member)


//추가,수정,삭제,목록
//member (회원 아이디, 이름, 연락처, 포인트)

//db의 테이블의 데이터 (tbl_member)에 대응
public class Member {
	private String memberId;//member_id
	private String memberName;//member_name
	private String phone;
	private int point;
//	생성자
	
	public Member() {}
	public Member(String memberId,String memberName,String phone,int point) {
		this.memberId=memberId;
		this.memberName=memberName;
		this.phone=phone;
		this.point=point;
		
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", phone=" + phone + ", point=" + point
				+ ", getMemberId()=" + getMemberId() + ", getMemberName()=" + getMemberName() + ", getPhone()="
				+ getPhone() + ", getPoint()=" + getPoint() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

	}
	




