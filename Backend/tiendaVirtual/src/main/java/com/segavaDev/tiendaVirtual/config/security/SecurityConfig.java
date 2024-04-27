package com.segavaDev.tiendaVirtual.config.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.segavaDev.tiendaVirtual.config.security.filtros.FiltroRedirigirDashboard;
import com.segavaDev.tiendaVirtual.config.security.filtros.JWTValidationFilter;
import com.segavaDev.tiendaVirtual.services.jwt.JWTUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        private static final String[] SWAGGER_WHITELIST = {
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-resources/**",
                        "/swagger-resources"
        };

        private final String[] AUTHENTICATED_PATHS = {
                        "/dashboard.html",
        };

        private final String[] WHITE_LIST = {
                        "/api/v1/public/**",
                        "/registrar.html",
                        "/authenticate",
                        "/login.html",
                        "/index.html",
                        "/error/**",
                        "/assets/**",
                        "/css/**",
                        "/js/**",
                        "/"

        };

        private final String[] USER_PATHS = {
                        "/api/v1/usuario/**"
        };

        private final String[] GERENTE_PATHS = {
                        "/api/v1/gerente/**"
        };

        @Autowired
        public JWTValidationFilter jwtValidationFilter;

        @SuppressWarnings("unused")
        private final JWTUserDetailService jwtUserDetailService;

        public SecurityConfig(JWTUserDetailService jwtUserDetailService) {
                this.jwtUserDetailService = jwtUserDetailService;
        }

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http)
                        throws Exception {

                http.csrf(csrf -> csrf.disable());
                http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                http.authorizeHttpRequests(auth -> auth
                                .requestMatchers(AUTHENTICATED_PATHS).authenticated()
                                .requestMatchers(GERENTE_PATHS).hasRole("GERENTE")
                                .requestMatchers(USER_PATHS).hasRole("USUARIO")
                                .requestMatchers(WHITE_LIST).permitAll()
                                .requestMatchers(SWAGGER_WHITELIST).permitAll()
                                .anyRequest().authenticated())
                                .addFilterBefore(jwtValidationFilter, BasicAuthenticationFilter.class)
                                .addFilterAfter(new FiltroRedirigirDashboard(), UsernamePasswordAuthenticationFilter.class);

                

                http.httpBasic(
                                basic -> basic.disable());
                http.formLogin(
                                form -> form.disable());
                http.cors(cors -> corsConfigurationSource());

                return http.build();
        }

        @SuppressWarnings("deprecation")
        @Bean
        PasswordEncoder passwordEncoder() {
                return NoOpPasswordEncoder.getInstance();
        }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
                var config = new CorsConfiguration();

                config.setAllowedOrigins(List.of("*"));
                config.setAllowedMethods(List.of("*"));
                config.setAllowedHeaders(List.of("*"));
                config.setAllowCredentials(true);

                var source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", config);

                return source;
        }

        @Bean
        AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
                return configuration.getAuthenticationManager();
        }
}
