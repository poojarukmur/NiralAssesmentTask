package in.pooja.configur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception{
		
		http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth-> auth
				.requestMatchers("/students").permitAll().requestMatchers("/students/**")
				.authenticated()).httpBasic();
		return http.build();
	
		
	}
	
    


}