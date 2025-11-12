package com.example.demo.securityCongfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsService  userDetailsService(PasswordEncoder passwordEncoder) {
		
		UserDetails user1= User.withUsername("sakshi")
				.password(passwordEncoder.encode("345"))
				.authorities("roll-admin")
				.build();
		
		
		UserDetails user2= User.withUsername("surabh")
				.password(passwordEncoder.encode("123"))
				.authorities("roll-manager")
				.build();
		
		
		return new InMemoryUserDetailsManager(user1,user2);
	}
		
		@Bean
		public PasswordEncoder passwordEncoder2() {
			return new BCryptPasswordEncoder();
		}
	}
	

