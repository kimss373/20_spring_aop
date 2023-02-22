package com.spring.aop;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
 * 
 		# AOP( Aspect-Oriented Programming ) 관점 지향 프로그래밍

		- 프로젝트 개발 과정에서 핵심 기능 외에 추가적이고, 다양한 부가(공통) 기능이 필요하다. (로깅 , 보안 , 트랜잭션 , 테스트 , 등등)
		
		- 이 부가(공통)기능들은 프로젝트에 중요한 역할을 하며 이 부가(공통)기능이 코드마다 반복적(중복)으로 나타나는 부분이 존재한다. 
		
		- 코드에서 비즈니스 핵심 로직과 부가기능을 분리하여 부가 로직을 따로 관리(모듈화)한다.
		
		- 종단(비즈니스 로직) 기능 , 횡단(관심,Aspect) 기능 
		
		- 부가 기능이 비즈니스 로직(핵심 기능)을 담은 클래스의 코드에 전혀 영향을 주지 않으면서 부가기능의 구현을 용이하게 할 수 있는 구조를 제공한다.
		
		- AOP는 OOP를 대체하는 새로운 개념이 아니라 OOP를 돕는 보조적 기술 중에 하나 이다.
		
		- 스프링 DI  : 의존성(new)주입 , 스프링 AOP  : 로직(code) 주입
	
 * 
 * */

@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private Boss boss;
	
	@Autowired
	private Manager manager;
	
	@Autowired
	private Employee employee;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		boss.work();
		manager.work();
		employee.work();
		System.out.println();
		System.out.println("=================");
		System.out.println();
		
		boss.getWorkingTime();
		manager.getWorkingTime();
		employee.getWorkingTime();
		System.out.println();
		System.out.println("=================");
		System.out.println();
		
		boss.getInfo("사장", 1200);
		manager.getInfo("매니저", 700);
		employee.getInfo("직원", 300);
		
		System.out.println("\n==================\n");
//		employee.getError();  // 에러 발생
		
		return "home";
	}
	
}
