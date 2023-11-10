package comciudad.dona.entity;
import java.util.Date;
import java.util.UUID;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name="Category")

public class Category {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
		
	@Column(unique=true,nullable=false,length=100)
	private String Name ;
	@Column(name = "fotoUrl")
	private String foto_url;
	
	
	@Column(name="created_at",nullable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt; 
	@Column(name="updated_at",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate 
	private Date updatedAt; 
	@Column(name="activo",nullable=false)
	private Boolean activo;
	@Override
	 public int hashCode() {
	     return id.hashCode();
	 }
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;
	    Category other = (Category) obj; // Corregir la referencia a Category
	    return id.equals(other.id);
	}

}