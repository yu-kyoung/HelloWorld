package co.yedam;

import java.util.ArrayList;
import java.util.List;

/*
 * 등록,수정,삭제,목록 기능을 구현.
 * 저장은 storage에 반영하도록 함.
 */
public class EmpDAO {
	// 사원정보를 저장하는 컬렉션.
	List<Employee> storage = new ArrayList<Employee>();

	public void addMember(Employee insert) {
		storage.add(insert);

	}

	public void memberList() {
		System.out.printf("%s %s %s", "사번 이름 전화번호");
		for (int i = 0; i < storage.size(); i++) {
			String mid = storage.get(i).getMemberId();
			String name = storage.get(i).getMemberName();
			String phone = storage.get(i).getPhone();
		}

	}

	public void modify() {
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getMemberId().equals()) {
				storage.get(i).setPhone();
			}
		}
	}

	public void removeMember() {
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getMemberId().equals(mid2)) {
				storage.remove(i);
			}
		}
	}

	public void hireDate() {

	}

}
