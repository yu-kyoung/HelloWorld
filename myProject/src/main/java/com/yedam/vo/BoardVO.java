package com.yedam.vo;
//필드, 생성자, 메소드 (getter,setter)
//lombok 사용(설치 ,라이브러리)
//이클립스 실행파일 선택 인스톨 안될시 cmd

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class BoardVO {
	//필드 정의
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String writeDate;
	private int readCnt;
}
