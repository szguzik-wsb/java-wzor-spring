// Importowanie niezbędnych klas
package com.example.helpdesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // Metoda konfigurująca zabezpieczenia HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                // Konfiguracja autoryzacji żądań HTTP
                .authorizeHttpRequests((requests) -> requests
                        // Pozwolenie na publiczny dostęp do określonych URLi
                        .requestMatchers("/", "/home", "/register").permitAll()
                        // Wymaganie uwierzytelnienia dla wszystkich innych żądań
                        .anyRequest().authenticated()
                )
                // Konfiguracja formularza logowania
                .formLogin((form) -> form
                        // Strona logowania
                        .loginPage("/login")
                        // Pozwolenie na dostęp do strony logowania dla wszystkich
                        .permitAll()
                )
                // Konfiguracja wylogowania
                .logout((logout) -> logout
                        // Pozwolenie na wylogowanie dla wszystkich
                        .permitAll()
                        // URL wylogowania
                        .logoutUrl("/logout")
                        // URL przekierowania po wylogowaniu
                        .logoutSuccessUrl("/login?logout")
                );

        // Zwrócenie skonfigurowanego łańcucha filtrów zabezpieczeń
        return http.build();
    }

    // Bean do kodowania haseł
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Użycie BCrypt do kodowania haseł
        return new BCryptPasswordEncoder();
    }
}
