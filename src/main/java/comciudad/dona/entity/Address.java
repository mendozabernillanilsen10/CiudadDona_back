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
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
		
	@Column(name="Reference", length = 300,nullable=false)
	private String  Reference;
	@Column(name="street", length = 300,nullable=false)
	private String street; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public User idUser; 
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ubdistrito_Id", nullable = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ubdistrito ubdistrito_Id;

	@Column(name="created_at",nullable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt; 
	@Column(name="updated_at",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate 
	private Date updatedAt;
	
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((id == null) ? 0 : id.hashCode());
	    return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
