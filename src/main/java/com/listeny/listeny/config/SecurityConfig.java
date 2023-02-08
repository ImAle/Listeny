package com.listeny.listeny.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
    private UserDetailsService userDetailsService; // Gestión de usuario de Spring

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

        http.formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home",true)
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
                .requestMatchers( "/","/login","/registro").permitAll()
                //.requestMatchers("/crear_album").hasRole("ROL_ARTISTA")
                .requestMatchers(HttpMethod.POST,"/inicio").permitAll()
                .anyRequest().authenticated()

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
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(encoder);
        return authenticationProvider;
    }
}