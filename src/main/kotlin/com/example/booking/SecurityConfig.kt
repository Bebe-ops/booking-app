package com.example.booking

import org.springframework.context.annotation.Configuration
import org.springframework.security.authorization.AuthorityAuthorizationManager.hasAuthority
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter(){
    override fun configure(http: HttpSecurity?) {
        http?.httpBasic()
                ?.and()
                ?.authorizeRequests()
                ?.antMatchers("/hotels/**")?.hasRole("USER")
                ?.antMatchers("/customers/**")?.hasRole("USER")
                ?.antMatchers("/bookings/**")?.hasRole("USER")
                ?.antMatchers("/**")?.permitAll()
                ?.and()
                ?.csrf()?.disable()
                ?.formLogin()?.disable()

    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.inMemoryAuthentication()
                ?.withUser("admin")
                ?.password("{noop}password")
                ?.roles("USER") }
}