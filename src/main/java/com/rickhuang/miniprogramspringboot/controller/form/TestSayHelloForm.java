package com.rickhuang.miniprogramspringboot.controller.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

// 定义form类，并且定义其中的方法
@ApiModel
@Data
public class TestSayHelloForm {
	@NotBlank
	@Pattern(regexp="^[\\u4e00-\\u9fa5]{2,15}$")
	@ApiModelProperty("姓名")
	public String name;

}
