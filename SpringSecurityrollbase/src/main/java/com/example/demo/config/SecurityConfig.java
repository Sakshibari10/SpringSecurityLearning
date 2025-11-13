package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder)
	{
		UserDetails admin=User.withUsername("sakshi")
				.password(passwordEncoder.encode("sakshi"))
				.roles("ADMIN")
				.build();
		
		
		UserDetails user=User.withUsername("rahul")
				.password(passwordEncoder.encode("rahil"))
				.roles("USER")
				.build();
		
		                                                                        
		
		
		UserDetails manager=User.withUsername("mohit")
				.password(passwordEncoder.encode("mohit"))
				.roles("MANAGER")
				.build();
		
		
		UserDetails customer=User.withUsername("sona")
				.password(passwordEncoder.encode("sona"))
				.roles("CUSTOMER")
				.build();
		return new InMemoryUserDetailsManager(admin,user,manager,customer) ;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->auth
			     .requestMatchers("/admin/**").hasAnyRole("ADMIN","MANAGER")
				.requestMatchers("/user/**").hasAnyRole("ADMIN","USER","MANAGER")
				.requestMatchers("/manager/**").hasRole("MANAGER")
				.requestMatchers("/customer/**").permitAll().anyRequest().authenticated()).httpBasic(customizer -> {}).formLogin(login->login.permitAll()).logout(logout->logout.permitAll());
		return httpSecurity.build();
		
		
	}
}
