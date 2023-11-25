package comciudad.dona.service;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import comciudad.dona.entity.ImagesProduct;


public interface ImagesProductService {
	public List<ImagesProduct> findAll();

	public ImagesProduct findById(UUID id);

	public ImagesProduct save(ImagesProduct objet, List<MultipartFile> file);

	public void delete(UUID id);
}
