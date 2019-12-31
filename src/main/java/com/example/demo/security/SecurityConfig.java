package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired //pour l'injection
	private UserDetailsService userDetailsService;
	
	protected void configure(HttpSecurity http)throws Exception{
		//authentification basique ;il y a plusieurs methodes
		http
		.httpBasic()
		.and().authorizeRequests().antMatchers("/api/**")
		.hasRole("USER").antMatchers("/**").hasRole("ADMIN").and()
		.csrf().disable().headers().frameOptions().disable();
		//http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/", "/**").permitAll();
        //http.authorizeRequests().antMatchers(HttpMethod.GET, "/", "/**").permitAll();
	}
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
				NoOpPasswordEncoder.getInstance());
		//auth.inMemoryAuthentication().passwordEncoder(
			//	NoOpPasswordEncoder.getInstance());
		//.withUser("user").password("password")
		//.roles("USER").and().withUser("admin").password("password2")
		//.roles("USER","ADMIN");
		
	}
}
