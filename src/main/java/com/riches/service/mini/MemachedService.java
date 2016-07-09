package com.riches.service.mini;

import org.springframework.stereotype.Service;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;

@Service
public class MemachedService {
	@ReadThroughSingleCache(namespace = "test", expiration = 30000)
	public String getInfo(@ParameterValueKeyProvider final String key) {
		System.out.println("ª∫¥Ê√ª”–√¸÷–");
		return "ª∫¥Ê≤‚ ‘2016-07-09";
	}
}
