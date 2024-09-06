package microservices.accountancy.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@ConfigurationProperties("hospital.accountancy")
public class SecurityConfiguration {

    private List<Credentials> credentials;

    public void setCredentials(List<Credentials> credentials) {
        this.credentials = credentials;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/patients").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(credentials.stream()
                .map(toUserDetails(encoder))
                .collect(toList()));
    }

    private Function<Credentials, UserDetails> toUserDetails(PasswordEncoder encoder) {
        return credentials -> User.withUsername(credentials.getUsername())
                .password(encoder.encode(credentials.getPassword()))
                .authorities(credentials.getAuthorities())
                .build();
    }
}
