package org.bspv.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Order(SecurityProperties.BASIC_AUTH_ORDER-2)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth
            .inMemoryAuthentication()
            .withUser("admin").password("{noop}admin").roles("ADMIN")
            .and()
            .withUser("user").password("{noop}password").roles("USER")
      ;
    }// @formatter:on

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
//        .antMatchers("/oauth/token/revokeById/**").permitAll()
        .antMatchers("/tokens/**").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().csrf().disable();
        ;
    }
    
    
}
