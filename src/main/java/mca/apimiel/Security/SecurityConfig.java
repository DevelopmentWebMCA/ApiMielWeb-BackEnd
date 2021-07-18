package mca.apimiel.Security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import mca.apimiel.Servicios.UserService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userDetailService;
	
	//@Autowired
	//private BCryptPasswordEncoder bCrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		return bcryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http
		.authorizeRequests()
		.anyRequest()
		
		.authenticated()
		.and()
		.httpBasic();*/
		http
		.authorizeRequests()
		.anyRequest()
		.permitAll()
        .and().cors().configurationSource(corsConfigurationSource());
		
		http.csrf().disable();
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {

        //System.out.println(origin);

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(Arrays.asList("*"));

        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));

        config.setAllowCredentials(true);

        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

        

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return source;

    }

}
