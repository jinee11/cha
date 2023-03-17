package com.my.cha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.my.cha.member.MemberService;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	
	
   
   @Bean
   SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	   //http.csrf().disable();
      http.authorizeHttpRequests().requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
      
//      .and()
//         .csrf()
//         .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
      .and()
         .headers()
         .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
      .and()
         .formLogin()
         .loginPage("/login")
         .defaultSuccessUrl("/")
      .and()
         .logout()
         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
         .logoutSuccessUrl("/")
         .invalidateHttpSession(true)
         ;
      
      //로그인시 403에러 발생해서 추가/이거 추가하면 회원가입이 안됨/해결
      http.csrf().disable();
      
      
   return http.build();
   
   }
   
   @Bean
   AuthenticationManager authenticateionManager(AuthenticationConfiguration authenticationConfiguration) 
   throws Exception{
      return authenticationConfiguration.getAuthenticationManager();
   }
   
   @Bean
   PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }
   
}