package comciudad.dona.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import comciudad.dona.service.fileService;
@Service
public class file implements fileService {

	@Value("${spring.servlet.multipart.location}")
	 private String uploadPath;
	@Override
	public void init() {
		try {
			Files.createDirectories(Paths.get(uploadPath));
		} catch (IOException e) {
			throw new RuntimeException("¡No se pudo crear la carpeta de carga!");
		}
	}
	@Override
	public Path load(String filename) {
		   return Paths.get(uploadPath).resolve(filename);
	}
   @Override
   public Resource loadAsResource(String filename) {
	   try {
		   Path file = load(filename);
		   Resource resource = new UrlResource(file.toUri());
		   
		   
		   if (resource.exists() || resource.isReadable()) {
			   return resource;
		   } else {
			   throw new RuntimeException("No se pudo leer el archivo: " + filename);
		   }
	   } catch (MalformedURLException e) {
		   throw new RuntimeException("No se pudo leer el archivo: " + filename, e);
	   }
   }
    @Override
	public void deleteFoto(String fotoUrl) {
		if (fotoUrl != null) {
			Path filePath = Paths.get(uploadPath, fotoUrl);
			try {
				Files.deleteIfExists(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
