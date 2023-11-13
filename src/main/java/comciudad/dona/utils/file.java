package comciudad.dona.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class file {
    private static final String UPLOAD_DIR = "src//main//resources//static//imagenes";

	 // Método para guardar la foto en el servidor y retornar la URL de la foto guardada
	    public String saveFoto(MultipartFile foto) {
	        try {
	            String fileName = UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
	            Path filePath = Paths.get(UPLOAD_DIR, fileName);
	            Files.copy(foto.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	            return fileName;
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    // Método para eliminar la foto del servidor
	    public void deleteFoto(String fotoUrl) {
	        if (fotoUrl != null) {
	            Path filePath = Paths.get(UPLOAD_DIR, fotoUrl);
	            try {
	                Files.deleteIfExists(filePath);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
}
