package id.co.sosmed.front.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> {
                    // login
                    request.requestMatchers(
                            "/error",
                            "/home**",
                            "/login**",
                            "/posts**",
                            "/profile-setting**").permitAll();

                    // resources
                    request.requestMatchers(
                            "/resources/**",
                            "/images/**",
                            "/templates/**",
                            "/reports/**",
                            "/css/**",
                            "/js/**",
                            "/vendors/**",
                            "/img/**",
                            "/scss/**",
                            "/fonts/**").permitAll();

                    request.anyRequest().authenticated();
                })
                .formLogin(login -> login.loginPage("/home")
                        .loginProcessingUrl("/security_check")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll())
                .logout(logout -> logout.logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/logout-successful")
                        .permitAll())
                .rememberMe(remember -> remember.rememberMeParameter("remember-me")
                        .key("myKey")
                        .tokenValiditySeconds(60));
        return http.build();
    }
}
