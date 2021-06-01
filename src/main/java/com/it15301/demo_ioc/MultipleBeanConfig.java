package com.it15301.demo_ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.it15301.dto.User;

@Configuration
public class MultipleBeanConfig {
	@Bean("beanTienNH21")
	public User getUser1()
	{
		User myUser = new User();
		
		myUser.setName("TienNH21");
		
		return myUser;
	}

	@Bean("beanDungNA29")
	public User getUser2()
	{
		User myUser = new User();
		
		myUser.setName("DungNA29");
		
		return myUser;
	}
}
