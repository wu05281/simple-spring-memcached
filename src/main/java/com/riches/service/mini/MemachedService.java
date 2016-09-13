package com.riches.service.mini;

import org.springframework.stereotype.Service;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;

@Service
public class MemachedService {
	@ReadThroughSingleCache(namespace = "test", expiration = 30000)
	public String getInfo(@ParameterValueKeyProvider final String key) {
		System.out.println("缓存没有命中");
		return "缓存测试2016-07-09";
	}
	
	@ReadThroughSingleCache(namespace="test", expiration=30)
	public User getUser() {
		System.out.println("缓存没有命中");
		User user = new User();
		user.setId(1111L);
		user.setName("test124");
		return user;
	}
}
