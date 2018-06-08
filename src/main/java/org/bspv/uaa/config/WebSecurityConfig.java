package org.bspv.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth
            .inMemoryAuthentication()
            .withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN")
            .and()
            .withUser("user").password(passwordEncoder.encode("password")).roles("USER")
      ;
    }// @formatter:on

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .defaultSuccessUrl("/")
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
        // @formatter:on
    }
    
    
}
