package com.example.mbboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication // 애노테이션 controller , service , mapper 자동 스캔후 bean 등록 
@ServletComponentScan  // 애노테이션 WEBservlet , Listener 자동 스캔후 bean 등록
public class MbboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbboardApplication.class, args);
	}

}
