package hospital.hongik_hospital.repository;
import hospital.hongik_hospital.domain.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public interface ReserveRepository extends JpaRepository<Reserve,Long>{

}
