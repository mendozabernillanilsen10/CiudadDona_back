package comciudad.dona.converters;

import java.util.Date; 
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import comciudad.dona.dtos.StoreRequestDTO;
import comciudad.dona.dtos.TimetableDTO;
import comciudad.dona.entity.Store;
import comciudad.dona.entity.Timetable;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.StoreService;
import comciudad.dona.service.SubCategoriaService;
import comciudad.dona.service.categoriaService;
import comciudad.dona.service.companiaService;
import comciudad.dona.service.fileService;
import comciudad.dona.converters.StoreRequestConverterts;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Company;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.entity.ubdistrito;

public class StoreRequestConverterts extends AbstractConverter<Store, StoreRequestDTO> {
	// private static final DateTimeFormatter dateTimeFormat =
	// DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
	private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
	@Autowired
	private categoriaService Categoriaservice;
	@Autowired
	private SubCategoriaService SubCategoriaservice;
	

	 @Autowired
	 private DistritoService Distritoservice;
	  
	@Autowired
	private companiaService companiservice;

	@Override
	public StoreRequestDTO fromEntity(Store entity) {
		if (entity == null)
			return null;
		List<TimetableDTO> detalles = fromIngresoDetalleEntity(entity.getHorarios());

		return StoreRequestDTO.builder().id(entity.getId()).horarios(detalles).nombre(entity.getName()).build();
	}

	@Override
	public Store fromDTO(StoreRequestDTO dto) {
		if (dto == null)
			return null;
		List<Timetable> detalles = fromIngresoDetalleDTO(dto.getHorarios());

		Store store = new Store();
		store.setName(dto.getNombre());
		
		
		if ( dto.getIdDistrito() != null && !dto.getIdDistrito().toString().isEmpty()) {
		   
			
			ubdistrito distrito = Distritoservice.findById(dto.getIdDistrito());
		    if (distrito != null) {
		        store.setIdDistrito(distrito);
		    }
		}
		if (dto.getCompanId()!= null && !dto.getCompanId().toString().isEmpty()) {
		    Company company = companiservice.findById(dto.getCompanId());
		    if (company != null) {
		        store.setCompany(company);
		    }
		}
		if( dto.getCategorId() !=null && !dto.getCategorId().toString().isEmpty()) {
			Category categoria = Categoriaservice.findById(dto.getCategorId());
			if(categoria != null) {
			store.setCategory(categoria != null ? categoria :null );
			}
		}
		if(dto.getSubcatId() != null && !dto.getSubcatId().toString().isEmpty() ) {
			Subcategory subCategoria =SubCategoriaservice.findById(dto.getSubcatId());
			if(subCategoria !=null ) {
				store.setSubcategory(subCategoria != null ? subCategoria :null);
			}
		}
		
		return store;
		/*
		
		return Store.builder().id(dto.getId()).name(dto.getNombre())
				.idDistrito(dto.getIdDistrito() != null && !dto.getIdDistrito().toString().isEmpty()
						? Distritoservice.findById(dto.getIdDistrito())
						: null)
				.company(dto.getCompanId() != null && !dto.getCompanId().toString().isEmpty()
						? companiservice.findById(dto.getCompanId())
						: null)
				.category(dto.getCategorId() != null && !dto.getCategorId().toString().isEmpty()
						? Categoriaservice.findById(dto.getCategorId())
						: null)
				.subcategory(dto.getSubcatId() != null && !dto.getSubcatId().toString().isEmpty()
						? SubCategoriaservice.findById(dto.getSubcatId())
						: null)
				.horarios(detalles).build();*/
		
		
	}

	private List<TimetableDTO> fromIngresoDetalleEntity(List<Timetable> detalles) {
		if (detalles == null)
			return null;
		return detalles.stream().map(detalle -> {
			return TimetableDTO.builder().id(detalle.getId()).apertura(formatTime(detalle.getApertura()))
					.cierre(formatTime(
							detalle.getCierre())).build();
		}).collect(Collectors.toList());
	}

	private List<Timetable> fromIngresoDetalleDTO(List<TimetableDTO> detalles) {
		if (detalles == null)
			return null;
		return detalles.stream().map(detalle -> {
			return Timetable.builder().Apertura(
					parseTime(detalle.getApertura()))
					.Cierre(parseTime(detalle.getCierre()))
					.build();
		}).collect(Collectors.toList());
	}

	private Date parseTime(String time) {
		if (time == null)
			return null;
		LocalTime localTime = LocalTime.parse(time, dateTimeFormat);
		Instant instant = localTime.atDate(LocalDate.of(1970, 1, 1)).atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}

	private String formatTime(Date date) {
		if (date == null)
			return null;
		Instant instant = date.toInstant();
		LocalTime localTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
		return localTime.format(dateTimeFormat);
	}

}
