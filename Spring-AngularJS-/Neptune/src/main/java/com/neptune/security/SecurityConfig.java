package com.neptune.security;
/**
 * @author Boubacar KOITA alias Tocka
 *  Security configuration class
 */
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception{
		
		// coding the credentials in java code (in memory)
		/**
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN","MANAGER","CUSTOMER");
		auth.inMemoryAuthentication().withUser("manager").password("123").roles("MANAGER","CUSTOMER");
		auth.inMemoryAuthentication().withUser("customer").password("123").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("lamda").password("123").roles("");
		*/
	
		// using database for saving credentials
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")
			.authoritiesByUsernameQuery("select users as principal, roles as role from user_roles where users = ?")
			.rolePrefix("ROLE_");
		
		
		// saving credentials in LDAP
		/**
		 * .ldapAuthentication()
					.userDnPatterns("uid={0},ou=people")
					.groupSearchBase("ou=groups")
					.contextSource().ldif("classpath:test-server.ldif");
			}
		 */
	}
	
	
	/**
	 * resources authorisation  and form authentication configuration
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/css/**","/js/**","/images/**").permitAll()
				.anyRequest()
					.authenticated()
					.and()
		    .formLogin()
		    	.loginPage("/login")
		    	.permitAll()
		    	.defaultSuccessUrl("/index.html")
		    	;
	}
	

}
