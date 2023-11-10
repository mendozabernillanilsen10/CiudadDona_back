package comciudad.dona.entity;

import java.util.UUID;   
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Genero")
@EntityListeners(AuditingEntityListener.class)
public class Genero {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
	@Column(name="genero", length = 50,nullable=false)
	String genero;
}
