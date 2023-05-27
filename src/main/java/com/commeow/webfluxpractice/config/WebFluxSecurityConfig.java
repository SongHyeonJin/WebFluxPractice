package com.commeow.webfluxpractice.config;

import com.commeow.webfluxpractice.security.AuthenticationManager;
import com.commeow.webfluxpractice.security.SecurityContextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class WebFluxSecurityConfig {
    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository securityContextRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        http.authorizeExchange((exchanges) -> exchanges
                .pathMatchers("/members/signup", "/members/login").permitAll()
                .anyExchange().authenticated()).formLogin().disable().csrf()
                .disable().cors().and().exceptionHandling()
                .authenticationEntryPoint((swe, e) -> Mono
                        .fromRunnable(() -> swe.getResponse().setStatusCode(
                                HttpStatus.UNAUTHORIZED)))
                .accessDeniedHandler((swe, e) -> Mono.fromRunnable(() -> swe
                        .getResponse().setStatusCode(HttpStatus.FORBIDDEN)))
                .and().authenticationManager(authenticationManager)
                .securityContextRepository(securityContextRepository);
        return http.build();
    }
}
