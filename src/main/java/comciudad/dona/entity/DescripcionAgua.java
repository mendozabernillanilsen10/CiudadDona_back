package comciudad.dona.entity;

import java.util.Date;
import java.util.UUID;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "DescripcionAgua")
public class DescripcionAgua {
	@Id
	@GeneratedValue
	@Column(length = 16)
	private UUID id;


	@Column(name = "stock", nullable = false)
	private int stock;

	@Column(name = "unidadPaquete", nullable = true)
	private int unidadPaquete;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcontainerType" , nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ContainerType containerType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmedidasProducto" , nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private MedidasProducto medidasProducto;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idunidadMedida")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private UnidadMedida unidadMedida;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproducto")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Product Product;
	
	@Column(name = "price", nullable = false, columnDefinition = "DECIMAL(10,2)")
	private Double price;

	@Column(name="DetalleEnbase", nullable = true)
	private String DetalleEnbase;
	
	@Column(name = "activo", nullable = false)
	private Boolean activo;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	
	private Date createdAt;
	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
}
