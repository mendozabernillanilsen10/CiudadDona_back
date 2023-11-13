package comciudad.dona.utils;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import comciudad.dona.dtos.AuthResponse;
import comciudad.dona.dtos.RolDTO;
import comciudad.dona.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
