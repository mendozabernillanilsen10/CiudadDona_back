package comciudad.dona.config;

import java.util.Properties;  
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Configuration
public class EmailConfig {
  @Value("${spring.mail.host}")
  private String mailHost;
  @Value("${spring.mail.port}")
  private String mailPort;
  @Value("${spring.mail.username}")
  private String mailUsername;
  @Value("${spring.mail.password}")
  private String mailPassword;
  @Bean
  public JavaMailSender javaMailSender() {
    JavaMailSenderImpl sender = new JavaMailSenderImpl();
    sender.setHost(mailHost);
    sender.setPort(Integer.parseInt(mailPort));
    sender.setUsername(mailUsername);
    sender.setPassword(mailPassword);
    Properties props = sender.getJavaMailProperties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.connectiontimeout", "5000");
    props.put("mail.smtp.timeout", "3000");
    props.put("mail.smtp.writetimeout", "5000");
    props.put("mail.debug", "true");
    return sender;
  }

}
