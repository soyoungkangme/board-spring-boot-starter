package com.rubypaper.jdbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "board.jdbc")  // pom.xml에 configuration-processor 있어야 어노테이션 정상 동작  // 외부 프로퍼티 값으로 값 세팅 
public class JDBCConnectionManagerProperties {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
}


// SpringBoot02의 application.properties에서 board.jdbc로 시작하는 키값을 읽어서 @Data의 세터메서드로 세팅됨 

