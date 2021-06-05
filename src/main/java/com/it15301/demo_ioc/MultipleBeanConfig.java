package com.it15301.demo_ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.it15301.dto.UserDTO;

@Configuration
public class MultipleBeanConfig {
	@Bean("beanTienNH21")
	public UserDTO getUser1()
	{
		UserDTO myUser = new UserDTO();
		
		myUser.setUsername("TienNH21");
		
		return myUser;
	}

	@Bean("beanDungNA29")
	public UserDTO getUser2()
	{
		UserDTO myUser = new UserDTO();
		
		myUser.setUsername("DungNA29");
		
		return myUser;
	}
}
