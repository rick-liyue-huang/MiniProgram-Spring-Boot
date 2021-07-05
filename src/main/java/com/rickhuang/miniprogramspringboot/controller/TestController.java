package com.rickhuang.miniprogramspringboot.controller;

import com.rickhuang.miniprogramspringboot.common.util.R;
import com.rickhuang.miniprogramspringboot.controller.form.TestSayHelloForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
@Api("test web interface in swagger")
public class TestController {

	@PostMapping("/sayHello")
	@ApiOperation("swagger to test method")
	public R sayHello(@Valid @RequestBody TestSayHelloForm form) {
//		针对定义的form类，重新定义方法
		return R.ok().put("message", "Hello World!! " + form.getName());
	}
}
