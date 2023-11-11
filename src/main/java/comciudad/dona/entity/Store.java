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
@Table(name = "Store")
@EntityListeners(AuditingEntityListener.class)
public class Store {
	@Id
	@GeneratedValue
	@Column(length = 16)
	private UUID id;
	// @Column(name = "name", nullable = false)
	// private String name;
	// @Column(name="price", nullable = false,precision=6,scale=2)
	// private BigDecimal price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategory")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Category category;
	@Column(name = "Description")
	private String Description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsubcategory")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Subcategory subcategory;
	@Column(name = "fotoUrl")
	private String foto_url;
	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	@Column(name = "activo", nullable = false)
	private Boolean activo;

}
