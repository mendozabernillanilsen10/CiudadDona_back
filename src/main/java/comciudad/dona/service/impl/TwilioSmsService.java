package comciudad.dona.service.impl;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import comciudad.dona.config.TwilioConfig;
@Service
public class TwilioSmsService {
 @Autowired
 private TwilioConfig config;
 
 public void sendSms(String phone, String msg) {
  Message.creator(new PhoneNumber(phone), new PhoneNumber(config.getTrialNumber()), msg).create();
 }

}