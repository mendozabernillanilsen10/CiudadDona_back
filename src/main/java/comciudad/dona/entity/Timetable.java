package comciudad.dona.entity;

import java.util.Date; 
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;

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
@Table(name="Timetable")
@EntityListeners(AuditingEntityListener.class)
public class Timetable {
	@Id
	@GeneratedValue
	@Column(length = 16)
	private UUID id;
    @Column(name = "Apertura")
	@Temporal(TemporalType.TIME)
	@CreatedDate
	private Date Apertura;
    @Column(name = "Cierre")
	@Temporal(TemporalType.TIME)
	@CreatedDate
	private Date Cierre;
    @ManyToOne
    @JoinColumn(name="store_id")
    private Store store;
    
}