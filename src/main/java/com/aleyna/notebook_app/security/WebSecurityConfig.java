package com.aleyna.notebook_app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.aleyna.notebook_app.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
    UserDetailsService userDetailsService() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        return new CustomUserDetailsService();
    }
 
	
//	  @Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();
//	  }
	 
     
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        //authProvider.setPasswordEncoder(passwordEncoder());
//         
//        return authProvider;
//    }
    
//    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//    authProvider.setUserDetailsService(userDetailsService());
// 
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
         
        http.authProvider(authProvider());
        http.authorizeHttpRequests(auth ->
		auth .requestMatchers("/user").authenticated() 
            .anyRequest().permitAll()
            )
        .csrf(csrf -> csrf.disable())
            .formLogin(login ->
                login.usernameParameter("userName")
                .defaultSuccessUrl("/user")
                .permitAll()
            )
            .logout(logout -> logout.logoutSuccessUrl("/").permitAll() //http://localhost:8080/v1/notebook/logout urıında
        );
         
        return http.build();
    }  
}
