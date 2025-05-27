package com.yedam.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceDAO;
import com.yedam.vo.Member;

//사용자의 입력값을 등록, 수정, 삭제 , 목록 기능을 실행
public class MemberApp {
 public void execute() {
	 
	 Scanner scn=new Scanner (System .in);
	 MemberService svc= new MemberServiceDAO();
	boolean run=true;
	while(run) {
	 System.out.println("--------------------------------------");
	 System.out.println("1.회원등록 2.정보수정 3.회원삭제 4.목록보기 5.종료");
	 System.out.println("선택>> ");
	 int menu=scn.nextInt();scn.nextLine();
	 switch(menu) {
	 case 1: //등록
		 System.out.println("회원아이디>>");
		 String mid= scn.nextLine();
		 System.out.println("회원이름>>");
		 String name= scn.nextLine();
		 System.out.println("연락처>>");
		 String phone= scn.nextLine();
		 System.out.println("포인트>>");
		 String point= scn.nextLine();
	//MEmber member =new Member(mid,name,phone,Integer.parseInt(point)))    member
		 if(svc.addMember(new Member(mid,name,phone,Integer.parseInt(point)))) {
		System.out.println("등록완료");	 
		 }else {
			 System.out.println("등록실패");
		 }
	 case 2:
		 System.out.println("수정할 회원아이디>>");
		 Member mid1= scn.nextLine();
		 if(svc.modifyMember(mid1)) {
				System.out.println("수정완료");	 
				 }else {
					 System.out.println("수정실패");
				 }
		 
	 case 3:
		 System.out.println("삭제할 회원아이디>>");
		 String mid2= scn.nextLine();
		 if(svc.removeMember(mid2)) {
				System.out.println("삭제완료");	 
				 }else {
					 System.out.println("삭제실패");
				 }
	 case 4:
		 List<Member>list=svc.memberList();
		 System.out.println("회원id 이름 연락처");
		 System.out.println("-------------");
		 for(Member mbr:list) {
			 System.out.printf("%s  %s  %s\n",//
					 mbr.getMemberId(),mbr.getMemberName(),mbr.getPhone());
		 }
		 
	 case 5:
		 run=false;
		 System.out.println("종료");
	 }//switch
	}
 }//main
}
