/*
package com.finalproject.post;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.*;


@EnableWebSecurity
public class PostWebSecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
      .and()
      .csrf().disable()
      .authorizeRequests().antMatchers("/user/{id}/post" , "/user/{id}/post/{id}").permitAll()
      .anyRequest().authenticated()
      .and()
      .addFilter(new PostJWTAuthenticationFilter(authenticationManager()))
      .addFilter(new PostJWTAuthorizationFilter(authenticationManager()))
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }
  

  @Bean
  CorsConfigurationSource corsConfigurationSourcePost() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.applyPermitDefaultValues();
    corsConfig.setExposedHeaders(Arrays.asList("Authorization"));
    source.registerCorsConfiguration("/**", corsConfig);
    return source;
  }
}
*/
