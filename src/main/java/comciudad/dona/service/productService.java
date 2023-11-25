package comciudad.dona.service;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.Product;

@Service
public interface productService {
	public List<Product> findAll();
	public Product findById(UUID id);
	public Product save(Product objet);
	public void delete(UUID id);
}
