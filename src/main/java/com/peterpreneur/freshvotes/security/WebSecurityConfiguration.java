package com.peterpreneur.freshvotes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(getPasswordEncoder());
		/*
		 * auth.inMemoryAuthentication() .passwordEncoder(getPasswordEncoder())
		 * .withUser("peter") .password(getPasswordEncoder().encode("peter"))
		 * .roles("USER");
		 */
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//.csrf().disable()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest().hasRole("USER")
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/dashboard")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll();
		//super.configure(http);
	}
}
