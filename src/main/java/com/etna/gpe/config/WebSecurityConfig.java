package com.etna.gpe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private JwtRequestFilter filter;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoderBean() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticate) throws Exception{
		authenticate.userDetailsService(userDetailsService).passwordEncoder(passwordEncoderBean());
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf().disable().exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint)
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/authen/login_organization").permitAll()
			.antMatchers(HttpMethod.POST, "/authen/login_particular").permitAll()
			.antMatchers(HttpMethod.POST, "/organization/create_organization").permitAll()
			.antMatchers(HttpMethod.POST, "/organization/all_organization").permitAll()
			.antMatchers(HttpMethod.POST, "/particular/create_particular").permitAll()
			.antMatchers(HttpMethod.POST, "/particular/all_particular").permitAll()
			.antMatchers(HttpMethod.POST, "/event/all_events").permitAll()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll() //for allow cors policy request
			.anyRequest()
			.authenticated();
		httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		//H2 console needs this config
		httpSecurity.headers().frameOptions().sameOrigin()
				.cacheControl();
	}
}
