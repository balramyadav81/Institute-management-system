package Springboot.Institute.ManageMent.System.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Configure user details manager with a single user (surjith) having ADMIN role
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails surjith = User.builder()
                .username("surjith")
                .password("{bcrypt}$2a$12$zIYgOcWlpM6RD2WYNVho8u2ysVqb0FpV9CSUWNo8NUIv2vlXq0G9.")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(surjith);
    }

    // Configure security filter chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        // Define access control rules for different HTTP methods and endpoints
                        .requestMatchers(HttpMethod.GET,"/api/institutes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/institutes").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/institutes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/institutes/**").hasRole("ADMIN")

        );

        // Use HTTP Basic Authentication for securing endpoints
        http.httpBasic();

        // Disable Cross-Site Request Forgery (CSRF) protection
        // Not required for stateless REST APIs using GET, POST, PUT, DELETE, and PATCH
        http.csrf().disable();

        // Return the built SecurityFilterChain
        return http.build();
    }
}
