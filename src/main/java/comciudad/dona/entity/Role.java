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
@Table(name="Role")
@EntityListeners(AuditingEntityListener.class)
public class Role {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
	@Column(unique=true,nullable=false,length=100)
	private String Name ;
	@Column(name="created_at",nullable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt; 
	@Column(name="updated_at",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate 
	private Date updatedAt;
	
	
}
