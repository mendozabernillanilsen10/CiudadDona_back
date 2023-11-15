package comciudad.dona.service;
import java.nio.file.Path;
import org.springframework.core.io.Resource;

public interface fileService {
	 void init();
	 public Resource loadAsResource(String filename);
	 public Path load(String filename);
	 public void deleteFoto(String fotoUrl);
}
