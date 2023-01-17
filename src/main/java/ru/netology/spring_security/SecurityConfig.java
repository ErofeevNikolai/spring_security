package ru.netology.spring_security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Ivan").password("{noop}1234").authorities("read-age")
                .and()
                .withUser("Anton").password("{noop}4321").authorities("read-fio");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-age").hasAuthority("read-age")
                .and()
                .authorizeRequests().antMatchers("/persons/by-fio").hasAuthority("read-fio")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
