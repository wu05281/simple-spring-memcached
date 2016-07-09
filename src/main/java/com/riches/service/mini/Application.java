package com.riches.service.mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({"classpath:applicationContext-cache-memcached.xml"}) //����memached��xml�ļ�   
public class Application implements EmbeddedServletContainerCustomizer {  
	
	@RequestMapping("/")
	String home() {
		getInfo("test");
		return "hello world!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	//����Ĭ�������˿ں�
	public void customize(ConfigurableEmbeddedServletContainer container) {
		  container.setPort(1003);  
	}
	
	@ReadThroughSingleCache(namespace = "Alpha", expiration = 30)  
    private String getInfo(@ParameterValueKeyProvider final String key) {
    	System.out.println("����û������");
    	return "�������2016-07-09";
    }
}
