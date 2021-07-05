package com.rickhuang.miniprogramspringboot.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.crypto.SecretKeyFactory;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	swagger 的所有配置信息都是封装到Docket对象中,并且返回给spring使用
//	Spring Bean是被实例的,组装的及被Spring 容器管理的Java对象。 Spring 容器会自动完成@bean对象的实例化
	@Bean
	public Docket createRestApi() {
		DocumentationType documentationType;
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
//		设置swagger页面基本信息
		ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("EMOS Online Office");
//		这里需要进一步封装成ApiInfo对象
		ApiInfo info = builder.build();
//		将info对象传给docket对象
		docket.apiInfo(info);
//		这时候就有了swagger页面的标题

//		接下来将controller里面的方法也放入进来
		ApiSelectorBuilder selectorBuilder = docket.select();
//		设置一下哪个包的哪个类添加进来,还有类中哪些方法添加进来
		selectorBuilder.paths(PathSelectors.any()); // 这里让其所有方法都添加进来

//		进行限定，一些特定注解的特定方法才可以填进swagger页面中, 只要加入了@ApiOperation注解就可以
		selectorBuilder.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class));
//		将其赋值给docket变量，就实现了更新
		docket = selectorBuilder.build();

//		swagger 将支持jwt
		/**
		 * 从header里面得到token的名字下面的token信息
		 */
		ApiKey apiKey = new ApiKey("token", "token", "header" );
		List<ApiKey> apiKeyList = new ArrayList<>();
		apiKeyList.add(apiKey);
//		这时候swagger知道了才请求头里的token参数提交的令牌字符串
		docket.securitySchemes(apiKeyList);

//		设定作用域
		AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] scopes = {scope};
//		接着对数组进行封装
		SecurityReference reference = new SecurityReference("token", scopes);
//		继续封装，放到list
		List refList = new ArrayList();
		refList.add(reference);
//		继续封装为SecurityContext
		SecurityContext context = SecurityContext.builder().securityReferences(refList).build();
//		继续封装为List
		List cxtList = new ArrayList();
		cxtList.add(context);
		docket.securityContexts(cxtList); // 直到这时候在swagger才开启JWT

//		这个时候只是在swagger中开启了jwt，而没有在springboot中融合jwt,接着做这步
		return docket;
	}
}
