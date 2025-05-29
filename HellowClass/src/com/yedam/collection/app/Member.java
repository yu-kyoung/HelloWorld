package com.yedam.collection.app;



public class Member {

	private String memberId;
	public String memberName;
	private String phone;
	private int point;
	public int age;

	public Member() {
		// 매개값이 없는 생성자:기본생성자.
	}

	// 오른쪽 -소스- 밑에서2
	public Member(String memberId, String memberName, String phone, int point) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}

	// 오른쪽 -소스- 위에서2
	// 전체필드를 매개값으로 갖는 생성자
	String getMemberId() {
		return memberId;
	}

	void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	String getMemberName() {
		return memberName;
	}

	void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	String getPhone() {
		return phone;
	}

	void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	void setPoint(int point) {
		this.point = point;
	}
	public void showInfo() {
		System.out.printf("이름은 %s, 연락처는 %s, 포인트는 %d\n ",memberName,phone,point);
	}//이름 연락처 포인트 출력메소드

	// 배열에서 point가 제일 큰사람을 찾아서 반환.

	Member getMaxPoint(Member[] memberArray) {
		// 결과값
		Member max = null;

		int maxPoint = 0;// 포인트를 비교하기위한 변수
		for (int i = 0; i < memberArray.length; i++) {
			if (maxPoint < memberArray[i].getPoint()) {
				maxPoint = memberArray[i].getPoint();
				max = memberArray[i];

			}

		}

		return max;
	}

//	//메소드 (getter, setter)
//	String getMemberId() {
//		return memberId;
//	}
//	void setMemberId(String memberId) {
//		this.memberId=memberId;
//	}
//	
//	String getMemberName() {
//		return memberName;
//	}
//	void setMemberName(String memberName) {
//		this.memberName=memberName;
//	}
//	
//	String getPhone() {
//		return phone;
//	}
//	void setPhone(String phone) {
//		this.phone=phone;
//	}
//	
//	int getPoint() {
//		return point;
//	}
//	void setPoint(int point) {
//		this.point=point;
//	}

}
//생성자
