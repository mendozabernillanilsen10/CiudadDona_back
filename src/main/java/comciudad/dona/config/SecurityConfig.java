package comciudad.dona.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import comciudad.dona.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {

        return http
            .csrf(csrf ->   csrf.disable())
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(authRequest ->
              authRequest.requestMatchers(
                		"/auth/**",
                		"/v1/login",
						"/v1/signup",
						"/v2/api-docs",
						"/v1/categorias/**",
						"v1/Company/**",
						"/webjars/**",
						"/v1/pais/**",
						"/v1/Address/**",
						"/v1/users/**",
						"/v1/Person/**",
						"/v1/provincia/**",
						"/v1/departamento/**",
						"/v1/Role/**",
						"/v1/Phone/**",
						"swagger-resources/**",
						"/v1/Distrito/**",
						"swagger-ui.html"	
                		).permitAll()
                .anyRequest().authenticated()
                )
            .sessionManagement(sessionManager->
                sessionManager 
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }
  
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*");
			}
		};
	}
    
    
}
