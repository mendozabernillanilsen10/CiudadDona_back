package comciudad.dona.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="ubdistrito")
@EntityListeners(AuditingEntityListener.class)
public class ubdistrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	@Column(name="nombre", length = 30,nullable=false)
	private String nombre;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProv")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public ubprovincia idProv; 

}
