package comciudad.dona.entity;
import java.util.UUID;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
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
@EntityListeners(AuditingEntityListener.class)
@Table(name="Brand")
public class Brand {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategory")
	private Category category;
	@Column(name="Name", length = 500,nullable=false)
	private String Name;
	
}
