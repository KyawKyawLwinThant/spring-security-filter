package com.example.springsecuritymasterfilters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Throwable {

        http.formLogin(c -> c.loginPage("/login")
                .failureUrl("/login-error")
                .permitAll()).logout(c -> c.logoutUrl("/logout")
                .logoutSuccessUrl("/login").permitAll())
                .authorizeHttpRequests(c -> {
                    c.requestMatchers("/bootstrap/**", "/").permitAll()
                            .requestMatchers("/department/list-departments","/department/create-department"
                            ,"/department/save-department").hasAnyRole("SUPER_ADMIN","DEPARTMENT_READ")
                            .requestMatchers("/customer/list-customers")
                            .hasAnyRole("CUSTOMER_READ","SUPER_ADMIN")
                            .requestMatchers("/employee/list-employees",
                                    "/employee/create-employee",
                                    "/employee/save-employee",
                                    "/employee/delete").hasAnyRole("EMPLOYEE_ADMIN","SUPER_ADMIN")
                            .requestMatchers("/customer/**","/department/**","/employee/**").hasRole("SUPER_ADMIN");
                            c.anyRequest().authenticated();
                }
        );
        return http.build();
    }

    @Bean

    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();
        var john = User.withUsername("john")
                .password("john")
                .roles("SUPER_ADMIN")
                .build();
        var emma = User.withUsername("emma")
                .password("emma")
                .roles("EMPLOYEE_ADMIN").build();
        var lucas = User.withUsername("lucas")
                .password("lucas")
                .roles("DEPARTMENT_READ", "DEPARTMENT_WRITE")
                .build();
        var richard = User.withUsername("richard")
                .password("richard")
                .roles("CUSTOMER_READ").build();
        var james = User.withUsername("james")
                .password("james")
                .roles().build();
        uds.createUser(john);
        uds.createUser(emma);
        uds.createUser(lucas);
        uds.createUser(richard);
        uds.createUser(james);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
