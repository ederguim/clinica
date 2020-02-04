package com.clinica.thais.araujo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth. //
		jdbcAuthentication() //
		.dataSource(dataSource) //
		.passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web. //
		ignoring(). //
		antMatchers("/", "/index.html", "/app/**", "/register", "/authenticate", "/favicon.ico");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http //
		.authorizeRequests() //
		.anyRequest() //
		.fullyAuthenticated() //
		.and()  //
				.addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class) //
				.httpBasic() //
				.and()
				.sessionManagement() //
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //
				.and() //
				.csrf() //
				.disable();
	}

}
