package com.oddle.tdv.boot.app;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OddleSecurity extends WebSecurityConfigurerAdapter{
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/tools/encode");
        web.ignoring().antMatchers("/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable();
//        http.exceptionHandling()
//                .and()
//                .anonymous()
//                .and()
//                .servletApi()
//                .and()
//                .headers().cacheControl()
//                .and().and().authorizeRequests().antMatchers("/**").authenticated();
//            .and().and().authorizeRequests().antMatchers("/**").hasAnyRole("HOMEDIRECT/AdminHome").anyRequest().authenticated()
//                .and()
//                .addFilterBefore(new CORSFilter(), UsernamePasswordAuthenticationFilter.class)
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder builder) {
                builder.dateFormat(new ISO8601DateFormat());
            }
        };
    }
}
