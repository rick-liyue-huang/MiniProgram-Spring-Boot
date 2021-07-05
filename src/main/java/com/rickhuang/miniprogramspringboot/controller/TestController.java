package com.rickhuang.miniprogramspringboot.controller;

import com.rickhuang.miniprogramspringboot.common.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api("test web interface in swagger")
public class TestController {
	@GetMapping("/sayHello")
	@ApiOperation("swagger to test method")
	public R sayHello() {
		return R.ok().put("message", "Hello World!!");
	}
}
