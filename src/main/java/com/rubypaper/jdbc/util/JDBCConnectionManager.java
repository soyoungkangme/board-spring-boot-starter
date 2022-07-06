package com.rubypaper.jdbc.util;

import lombok.Data;

// @EnableAutoConfiguration이 로딩하는 자동설정 클래스(BoardAutoConfiguration)에 빈등록된 클래스 


@Data
public class JDBCConnectionManager {
	
	public JDBCConnectionManager() {
		System.out.println("===> JDBCConnectionManager 생성");
	}
	
	private String driverClass;
	private String url;
	private String username;
	private String password;
	
}


