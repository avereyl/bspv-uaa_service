package org.bspv.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * Configuration of the login page and process.
 *
 */
@Configuration
@EnableWebSecurity
public class LoginConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .formLogin().loginPage("/login").permitAll()
        .and()
        .authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .passwordEncoder(new BCryptPasswordEncoder(16))
        .withUser("user").password("$2a$16$FvUg1927ZEOQwypj8owe/.lbZzJNJEHyjK/krDofploTMRAzNSeqq").roles("USER")//password
        .and()
        .withUser("admin").password("$2a$16$8BihqZAEWENS4.pexGDIbOU07AimTVexHiQjEzOr9O6lhstAkXZ/S").roles("ADMIN");//admin
    }
    
    
}
