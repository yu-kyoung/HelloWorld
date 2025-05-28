package co.yedam;

/*
 * 사원번호, 이름, 전화번호, 입사일자, 급여 항목을 필드로 선언하고
 * 필요한 메소드를 정의하세요.
 */
public class Employee {
	private String memberId;
	private String memberName;
	private String phone;
	private String hiredate;
	private int sal;

	public Employee() {}

	public Employee(String memberId, String memberName, String phone, String hiredate, int sal) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.hiredate = hiredate;
		this.sal = sal;
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

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [memberId=" + memberId + ", memberName=" + memberName + ", phone=" + phone + ", hiredate="
				+ hiredate + ", sal=" + sal + "]";
	}
	
	
	
	
	
	
	


}
