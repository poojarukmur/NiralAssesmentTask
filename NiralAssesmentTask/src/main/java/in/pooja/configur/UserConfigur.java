package in.pooja.configur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfigur {
	
	@Bean
	public InMemoryUserDetailsManager userdetailsservice() {
		UserDetails user=User.withUsername("admin").password("{noop}password").roles("USER").build();
		
		
		return new InMemoryUserDetailsManager(user);
		

}
}









    
