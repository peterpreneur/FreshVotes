package com.peterpreneur.freshvotes.service;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceTest {

	@Test
	public void generated_encrypted_password() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "peter";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println("Test");
		System.out.println(encodedPassword);
		
		//assertThat(rawPassword, not(encodedPassword));
	}
	
}
