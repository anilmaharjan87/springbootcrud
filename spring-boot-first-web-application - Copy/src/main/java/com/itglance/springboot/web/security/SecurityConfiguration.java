package com.itglance.springboot.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.inMemoryAuthentication().withUser("ram").password("{noop}ram123").roles("USERS","CEO");
        auth.inMemoryAuthentication().withUser("anil").password("{noop}anil123").roles("USERS","MANAGER");
        auth.inMemoryAuthentication().withUser("hari").password("{noop}hari123").roles("USERS","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception{
    http.authorizeRequests()
            .antMatchers("/").hasRole("USERS")
            .antMatchers("/leaders/**").hasRole("MANAGER")
            .antMatchers("/systems/**").hasRole("ADMIN")

   /* .anyRequest().authenticated()*/
    .and()
    .formLogin()
    .loginPage("/showMyLoginPage")
    .loginProcessingUrl("/authenticateTheUser")
    .permitAll()
    .and()
    .logout()
    .permitAll()
    .and()
    .exceptionHandling()
    .accessDeniedPage("/access-denied");
    }

}
