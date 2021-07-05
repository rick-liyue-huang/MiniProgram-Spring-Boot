package com.rickhuang.miniprogramspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 保证filter生效
@SpringBootApplication
public class MiniprogramSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniprogramSpringBootApplication.class, args);
	}

}
