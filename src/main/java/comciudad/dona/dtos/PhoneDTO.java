package comciudad.dona.dtos;

import java.util.UUID;

import comciudad.dona.entity.Person;
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
public class PhoneDTO {
	private UUID id;
	private String numero_celular  ;
	private String numero_whatsapp  ;
}
