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
@Table(name="Person")
@EntityListeners(AuditingEntityListener.class)
public class Person {
	@Id
	@GeneratedValue
	@Column(length=16)
	private UUID id;
	
    @Column(name = "Name",  nullable = false, length = 300)
    private String Name;

    @Column(name = "SurName",  nullable = true, length = 300)
    private String SurName;

    @Column(name = "DNI", nullable = false)
    private String DNI;

    @Column(name = "state", nullable = false)
    private Boolean state;

    @Column(name = "Date_of_Birth", nullable = false, updatable = false)
    private Date Date_of_Birth;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public User idUser; 
	
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
	     return id.hashCode();
	 }

	 @Override
	 public boolean equals(Object obj) {
	     if (this == obj)
	         return true;
	     if (obj == null || getClass() != obj.getClass())
	         return false;
	     Person other = (Person) obj; // Corregir la referencia a Category
	     return id.equals(other.id);
	 }

}
