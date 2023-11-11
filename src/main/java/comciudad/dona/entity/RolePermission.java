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
@Table(name="RolePermission")
@EntityListeners(AuditingEntityListener.class)
public class RolePermission {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rol")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public Role id_rol; 
    @ManyToOne(fetch=FetchType.LAZY)
   	@JoinColumn(name="permission_id")
   	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Permission permission_id;
    

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
        RolePermission other = (RolePermission) obj; // Corregir la referencia a Category
        return id.equals(other.id);
    }

}
