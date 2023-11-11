package comciudad.dona.entity;
import java.util.Collection;   
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import comciudad.dona.utils.RolesAcces;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User  implements UserDetails  {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
    @ManyToOne(fetch=FetchType.LAZY)
   	@JoinColumn(name="Role_Id")
   	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Role role;
    @Basic
	@Column(name="username", length = 300,nullable=false)
	private String username;
	@Column(name="password", length = 300,nullable=false)
	private String password;
	@Column(name="activo",nullable=false)
	private Boolean activo;
    
	@Enumerated(EnumType.STRING) 
	RolesAcces roles;
	@Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	      return List.of(new SimpleGrantedAuthority((roles.name())));
	    }
	    @Override
	    public boolean isAccountNonExpired() {
	       return true;
	    }
	    @Override
	    public boolean isAccountNonLocked() {
	       return true;
	    }
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

