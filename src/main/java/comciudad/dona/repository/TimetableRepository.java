package comciudad.dona.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.Timetable;
@Repository
public interface TimetableRepository extends JpaRepository<Timetable,UUID>{

}
