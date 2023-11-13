package comciudad.dona.utils;
import jakarta.mail.MessagingException;  
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

  @Autowired
  private JavaMailSender javaMailSender;
  correo  c= new correo();
  public void sendOtpEmail(String email, String otp) throws MessagingException {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
    mimeMessageHelper.setTo(email);
    mimeMessageHelper.setSubject("Verificacion de Cuenta");
    String content = c.getHtmlContent(otp);
    mimeMessageHelper.setText(content, true);
    javaMailSender.send(mimeMessage);
  }
}


