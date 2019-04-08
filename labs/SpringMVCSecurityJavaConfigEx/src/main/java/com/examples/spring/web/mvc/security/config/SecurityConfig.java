package com.examples.spring.web.mvc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
		return manager;
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
            	.antMatchers("/resources/**", "/signup", "/about").permitAll()                  
            	.antMatchers("/admin/**").hasRole("ADMIN")                                      
            	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")            
            .anyRequest().authenticated()  
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.and()
			.httpBasic();
	}	
}
