package comciudad.dona.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@Column(name="name",nullable=false,length=300)
	private String name ;

	@OneToMany(mappedBy="store", cascade=CascadeType.ALL)  
	private List<Timetable> horarios;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategory")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Category category;
	@ManyToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name = "idsubcategory")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Subcategory subcategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCompany")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Company company;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDistrito")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ubdistrito idDistrito;
	
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
