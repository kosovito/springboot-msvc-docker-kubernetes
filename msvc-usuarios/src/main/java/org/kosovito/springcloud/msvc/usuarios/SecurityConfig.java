package org.kosovito.springcloud.msvc.usuarios;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{/*
        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/authorized").permitAll()
                .requestMatchers(HttpMethod.GET, "/", "/{id}").hasAnyAuthority("read", "write")
                .requestMatchers(HttpMethod.POST, "/").hasAuthority("write")
                .requestMatchers(HttpMethod.PUT, "/{id}").hasAuthority("write")
                .requestMatchers(HttpMethod.DELETE, "/{id}").hasAuthority("write")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2Login(oauth2Login -> oauth2Login.loginPage("/oath2/authorization/msvc-usuarios-client"))
                .oauth2Client(withDefaults())
                .oauth2ResourceServer().jwt();

        return http.build();
        */
        http.cors().and().csrf().disable().authorizeHttpRequests(auth -> {
            try {
                auth
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/auth**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/", "/{id}").hasAnyAuthority("read", "write")
                        .requestMatchers(HttpMethod.POST, "/").hasAuthority("write")
                        .requestMatchers(HttpMethod.PUT, "/{id}").hasAuthority("write")
                        .requestMatchers(HttpMethod.DELETE, "/{id}").hasAuthority("write")
                        .anyRequest().authenticated()
                        .and()
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .oauth2Login(oauth2Login -> oauth2Login.loginPage("/oath2/authorization/msvc-usuarios-client"))
                        .oauth2Client(withDefaults())
                        .oauth2ResourceServer().jwt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return http.build();
    }
}
