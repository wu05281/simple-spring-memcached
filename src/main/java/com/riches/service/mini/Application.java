package com.riches.service.mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.ssm.api.ReadThroughSingleCache;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({"classpath:applicationContext-cache-memcached.xml"}) //����memached��xml�ļ�   
public class Application implements EmbeddedServletContainerCustomizer {  
	
	@RequestMapping("/")
	String home() {
		getInfo();
		return "hello world!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	//����Ĭ�������˿ں�
	public void customize(ConfigurableEmbeddedServletContainer container) {
		  container.setPort(1003);  
	}
	
	@ReadThroughSingleCache(namespace = "test", expiration = 30000)
    private void getInfo() {
    	System.out.println("����û������");
    }
}
