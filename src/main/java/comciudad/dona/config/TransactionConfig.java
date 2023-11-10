package comciudad.dona.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class TransactionConfig {
	 @Bean
	    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
	        return new DataSourceTransactionManager(dataSource);
	    }
}
