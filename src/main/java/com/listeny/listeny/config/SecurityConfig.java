package com.listeny.listeny.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService uds; // Gestión de usuario de Spring

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http.formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/inicio_logueado_usuario",true)

                .permitAll()
        );
        http.logout(logout -> logout
                        .logoutUrl("/login")
                        .logoutSuccessUrl("/")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        /*.logoutSuccessHandler(logoutSuccessHandler)
                        .invalidateHttpSession(true)
                        .addLogoutHandler(logoutHandler)
                        .deleteCookies(cookieNamesToClear)*/
        );
        http.authorizeHttpRequests()
                .requestMatchers("/login", "/registro", "/home").permitAll()
                .anyRequest().permitAll()

                .and()
                .exceptionHandling()
                .accessDeniedPage("/acceso_denegado")

                .and()
                .authenticationProvider(authenticationProvider())
                .csrf()
                ;

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(uds);
        authenticationProvider.setPasswordEncoder(encoder);
        return authenticationProvider;
    }
}