package comciudad.dona.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
@Component
public class OtpUtil {

  public String generateOtp() {
    Random random = new Random();
    int randomNumber = random.nextInt(999999);
    String output = Integer.toString(randomNumber);

    while (output.length() < 6) {
      output = "0" + output;
    }
    return output;
  }
}
