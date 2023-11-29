package comciudad.dona.entity;

import java.math.BigDecimal;  
import java.util.Date;
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
@Table(name="Oferta")
public class Oferta {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
	

	@Column(name="Nombre", length = 300)
	private String  Nombre;
	
	@Column(name = "price", columnDefinition = "DECIMAL(10,2)")
	private Double price;
	
	@Column(name = "cantidad")
	private BigDecimal cantidad;
	
	@Column(name = "fechaIncio", nullable = false, updatable = false)
    private Date fechaIncio;
	@Column(name = "fechafin", nullable = false, updatable = false)
    private Date fechafin;

	@Column(name="activo")
	private Boolean activo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDescripcionAgua")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private DescripcionAgua descripcionAgua;
	

}
