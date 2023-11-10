package comciudad.dona.entity;
import java.util.UUID;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name="Responsible")
public class Responsible {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
	@Column(name = "Name",  nullable = false, length = 300)
    private String Name;
    @Column(name = "SurName",  nullable = true, length = 300)
    private String SurName;
    @Column(name="celular", length = 30)
	private String celular ;
	@Column(name="whatsapp", length = 30)
	private String whatsapp ;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_Company")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public Company company; 

}
