package com.yedam.service;
//업무로직(등록,변경,삭제,출력)

import java.util.List;

import com.yedam.vo.Member;

public interface MemberService {
	public boolean addMember(Member member);
	public boolean modifyMember(Member member);
	public boolean removeMember(String memberId);
	public List<Member> memberList();//출력
}
