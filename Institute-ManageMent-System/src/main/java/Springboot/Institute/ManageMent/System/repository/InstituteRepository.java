package Springboot.Institute.ManageMent.System.repository;

import Springboot.Institute.ManageMent.System.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Spring Data JPA repository interface for Institute entities
@Repository
public interface InstituteRepository extends JpaRepository<Institute, Integer> {
}
