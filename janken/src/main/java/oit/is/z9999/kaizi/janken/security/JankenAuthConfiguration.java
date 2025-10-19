package oit.is.z9999.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class JankenAuthConfiguration {

  /**
   * 認証処理に関する設定（誰がどのようなロールでログインできるか）
   *
   * @return
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    // ユーザ名，パスワード，ロールを指定してbuildする
    // このときパスワードはBCryptでハッシュ化されているため，{bcrypt}とつける
    // ハッシュ化せずに平文でパスワードを指定する場合は{noop}をつける
    // ハッシュ化されたパスワードを得るには，この授業のbashターミナルで下記のように末尾にユーザ名とパスワードを指定すると良い(要VPN)
    // $ sshrun htpasswd -nbBC 10 user1 isdev
    // ハッシュ値は同じにならないので注意

    UserDetails user1 = User.withUsername("user1")
        .password("{bcrypt}$2y$10$PoDJGb5ehJ/W15rcqaWzWOQNwL9TlXk9viRd8m4FPCx4/qCU.EvtO").roles("USER").build();
    UserDetails user2 = User.withUsername("user2")
        .password("{bcrypt}$2y$10$B.N15gE6a08tVypUntHhBOrLfl0vaVYM3seCI64G2iLptpfmkgBye").roles("USER").build();

    // 生成したユーザをImMemoryUserDetailsManagerに渡す（いくつでも良い）
    return new InMemoryUserDetailsManager(user1, user2);
  }

  /**
   * 認可処理に関する設定（認証されたユーザがどこにアクセスできるか）
   *
   * @param http
   * @return
   * @throws Exception
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin(login -> login
        .permitAll())
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")) // ログアウト後に / にリダイレクト
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/janken**").authenticated() // /janken以下は認証済みであること
            .requestMatchers("/**").permitAll())// 上記以外は全員アクセス可能
        .csrf(csrf -> csrf
            .ignoringRequestMatchers("/h2-console/*"))
        .headers(headers -> headers
            .frameOptions(frameOptions -> frameOptions
                .sameOrigin()));
    return http.build();
  }

}
