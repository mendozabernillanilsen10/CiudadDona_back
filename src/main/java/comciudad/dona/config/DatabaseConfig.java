package comciudad.dona.config; 

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }
}
