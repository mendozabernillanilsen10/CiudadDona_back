package comciudad.dona.repository;
import java.util.UUID; 
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.Phone;
import comciudad.dona.entity.User;

public interface PhoneRepository extends JpaRepository<Phone,UUID>  {
	public Phone findBycelular(String celular);
	public Phone findBywhatsapp(String whatsapp);
	public Phone findByidUser(User idUser);
	
	
}
