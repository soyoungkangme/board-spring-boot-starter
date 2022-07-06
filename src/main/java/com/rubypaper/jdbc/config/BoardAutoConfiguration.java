package com.rubypaper.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.rubypaper.jdbc.util.JDBCConnectionManager;



//프로젝트 마오, run as, maven install, build success, close project 

// @EnableAutoConfiguration이 spring.factories 로딩하여 생성하는 자동설정 클래스 (= 객체 빈등록 하는 클래스)


@Configurable   // ConponentScan 범위에 들어가지 않음 (!= @Configuration)
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)    // != @EnableAutoConfiguration // @ConfigurationProperties 세트? 
public class BoardAutoConfiguration {
	
	@Autowired
	private JDBCConnectionManagerProperties properties;
	
	public BoardAutoConfiguration() {
		System.out.println("===> BoardAutoConfiguration 생성");
	}
	
	
	/*
	@Bean
	@ConditionalOnMissingBean  
    JDBCConnectionManager jdbcConnectionManager() {
        JDBCConnectionManager manager = new JDBCConnectionManager();
        manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
        manager.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        manager.setUsername("scott");
        manager.setPassword("tiger");
        return manager;
    }
    */
	
    
    @Bean   
    @ConditionalOnMissingBean    // JDBCConnectionManager 타입의 객체가 메모리에 없다면 객체 생성 (h2, oracle) 
    public JDBCConnectionManager jdbcConnectionManager() {
        JDBCConnectionManager manager = new JDBCConnectionManager();
        manager.setDriverClass(properties.getDriverClassName());    // 의존성 주입한 객체의 게터 메서드 이용     
        manager.setUrl(properties.getUrl());
        manager.setUsername(properties.getUsername());
        manager.setPassword(properties.getPassword());
        return manager;
    }
    // 외부 프로퍼티 정보 읽어서 설정 (JDBCConnectionManagerProperties,SpringBoot02)
}

