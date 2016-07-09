package com.riches.service.mini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class Application implements EmbeddedServletContainerCustomizer {  

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/")
	String home() {

		String sql = "select count(ua_ub_id_n) from User_Address where isactive = 1 and ua_ub_id_n = 151130101110000281";
		int i = jdbcTemplate.queryForObject(sql, Integer.class);
//		System.out.println(testRegistryService.hello("ok"));
		return "test query" + i;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	//更改默认启动端口号
	public void customize(ConfigurableEmbeddedServletContainer container) {
		  container.setPort(1003);  
	}
}
