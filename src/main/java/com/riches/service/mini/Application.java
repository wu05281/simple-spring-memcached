package com.riches.service.mini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({"classpath:applicationContext-cache-memcached.xml"}) //����memached��xml�ļ�   
public class Application implements EmbeddedServletContainerCustomizer {  

	@Autowired
	private MemachedService memachedService;
	
	@RequestMapping("/")
	String home() {
		memachedService.getUser();
		return "hello world!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	//����Ĭ�������˿ں�
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(1003);  
	}

	
}
