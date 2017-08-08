package com.oddle.tdv.boot.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OddleSecurity extends WebSecurityConfigurerAdapter{
    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/tools/encode");
//        web.ignoring().antMatchers("/api/**");
//        web.ignoring().antMatchers("/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.exceptionHandling()
                .and()
                .anonymous()
                .and()
                .servletApi()
                .and()
                .headers().cacheControl()
                .and().and().authorizeRequests().antMatchers("/**").hasRole("ANONYMOUS").anyRequest().authenticated()
//            .and().authorizeRequests().antMatchers("/**").hasAnyRole("HOMEDIRECT/AdminHome").anyRequest().authenticated()
                .and()
                .addFilterBefore(new CORSFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
