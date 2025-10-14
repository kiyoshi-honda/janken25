package oit.is.z9999.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  /**
   * Spring Securityのフィルタチェーン設定
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/", "/janken", "/janken/result").authenticated()
            .anyRequest().permitAll())
        .formLogin(form -> form
            .permitAll());
    return http.build();
  }

  /**
   * インメモリユーザ（yamada/tarou）設定
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.withUsername("yamada")
        .password("{noop}tarou")
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user);
  }
}
