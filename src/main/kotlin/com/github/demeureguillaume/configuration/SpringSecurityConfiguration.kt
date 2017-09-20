package com.github.demeureguillaume.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SpringSecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.inMemoryAuthentication()?.
                withUser("admin")?.password("admin")?.roles("ACTUATOR", "ADMIN", "USER")?.
                and()?.
                withUser("user")?.password("user")?.roles("USER")
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()?.
                mvcMatchers("/health", "/console/**")?.permitAll()?.
                anyRequest()?.authenticated()
        http?.httpBasic()
        http?.csrf()?.disable()
        http?.headers()?.frameOptions()?.disable()
    }

    override fun configure(web: WebSecurity?) {
        web?.ignoring()?.antMatchers(  "/v2/api-docs", "/configuration/**", "/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**")
    }

}