package com.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.exam.securityService.CustomUserService;



@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyConfig {
	
	@Bean
    public UserDetailsService userDetailsService() {
       return new CustomUserService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
    	DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    	daoAuthenticationProvider.setUserDetailsService(userDetailsService());
    	
    	return daoAuthenticationProvider;
    }


    
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
    
    
    

    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
   private JwtAuthenticationFilter filter;
    
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
    	
    	http.cors();

        http.csrf(csrf -> {
			try {
				csrf.disable();
			} catch (Exception e) {
				e.printStackTrace();
			}
		})
                
                .authorizeHttpRequests(authz->{
                        
                       authz.requestMatchers(new AntPathRequestMatcher("/generate-token"),
                    		   new AntPathRequestMatcher("/user")).permitAll();
                       authz .anyRequest().authenticated();
                })
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        
     
        return http.build();
    }



}
