package samyak.jain.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig{

	@Bean
    public InMemoryUserDetailsManager userDetailsManager() {
    	
        UserDetails Samyak = User.builder()
            .username("Samyak")
            .password("{noop}test123")
            .roles("EMPLOYEE")
            .build();

        UserDetails Satyam = User.builder()
                .username("Satyam")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails Kushal = User.builder()
                .username("Kushal")
                .password("{noop}test123")
                .roles("EMPLOYEE","ADMIN")
                .build();
        
        return new InMemoryUserDetailsManager(Samyak, Satyam, Kushal);  
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    		  
        return http
        		.authorizeRequests(configurer ->
        			configurer
        			.antMatchers("/").hasRole("EMPLOYEE")
    				.antMatchers("/leaders/**").hasRole("MANAGER")
    				.antMatchers("/systems/**").hasRole("ADMIN"))
        		
        		.formLogin(configurer ->
        			configurer
        				.loginPage("/showMyLoginPage")		
        				.loginProcessingUrl("/authenticateTheUser")
        				.permitAll())
        		
        		.logout(configurer -> 
        			configurer
        				.permitAll())
        		
        		.exceptionHandling(configurer ->
    				configurer
    				.accessDeniedPage("/access-denied"))
        		
        		.build();   
    }	

}
