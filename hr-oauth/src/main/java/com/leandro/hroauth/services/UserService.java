package com.leandro.hroauth.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.hroauth.entities.User;
import com.leandro.hroauth.feingclients.UserFeignClient;

import ch.qos.logback.classic.Logger;

@Service
public class UserService {
	
	private static Logger logger =  (Logger) LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found" + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found" + email);
		return user;
	}

}
