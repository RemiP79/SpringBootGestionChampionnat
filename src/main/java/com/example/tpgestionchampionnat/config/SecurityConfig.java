package com.example.tpgestionchampionnat.config;

import com.example.tpgestionchampionnat.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    /*@Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {
        UserDetails user = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }*/

    // Si tu utilises déjà CustomUserDetailsService pour tes membres en base,
    // alors tu peux commenter le bean ci-dessus et faire un @Primary sur ton service.

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/", "/inscription", "/home", "/login", "/static/css/**",
                                "/championship/list", "/championship/classement", "/championship/results", "/championship/jours",
                                "/team/list", "/team/fiche",
                                "/resultsDay", "/classement", "/joursChampionnat"
                        ).permitAll()
                        .requestMatchers(
                                "/championship/admin/**", "/championship/admin", "/championship/admin/add", "/championship/admin/edit", "/championship/admin/delete",
                                "/team/admin/**", "/team/admin", "/team/admin/add", "/team/admin/edit", "/team/admin/delete",
                                "/game/admin/**", "/game/admin", "/game/admin/add", "/game/admin/edit", "/game/admin/delete"
                        ).authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }

    // Pour permettre l'utilisation de l'AuthenticationProvider ailleurs (si besoin)
    @Bean
    public AuthenticationProvider authenticationProvider(AuthenticationConfiguration authConfig) throws Exception {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        System.out.println("🟢 daoAuthentificationPrivider initialisé");
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        return daoAuthenticationProvider;
    }

}
