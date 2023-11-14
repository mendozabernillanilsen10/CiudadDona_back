package comciudad.dona.config;
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class TwilioConfig {
 @Value("${twilio.account_sid}")
 private String accountSid;
 @Value("${twilio.auth_token}")
 private String authToken;
 @Value("${twilio.trial_number}") 
 private String trialNumber;
 @PostConstruct
 public void init() {
     Twilio.init(accountSid, authToken);
 }
}