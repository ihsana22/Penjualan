package com.indocyber.penjualan.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MvcSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/resources/**", "/user/**").permitAll()
			.anyRequest().authenticated()
			.and().formLogin()
			.loginPage("/user/loginForm")
			.loginProcessingUrl("/authenticating")
			.and().logout()
			.and().exceptionHandling().accessDeniedPage("/user/accessDenied");
		return http.build();
	}
}
