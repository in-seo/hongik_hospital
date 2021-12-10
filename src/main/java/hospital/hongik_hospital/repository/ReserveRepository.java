package hospital.hongik_hospital.repository;
import hospital.hongik_hospital.domain.Patient;
import hospital.hongik_hospital.domain.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class ReserveRepository{

    @PersistenceContext
    EntityManager em;

    @Transactional  //들어가야되나?
    public Long save(Reserve reserve) {
        em.persist(reserve);
        return reserve.getId();
    }
    public Reserve findById(Long id) {
        return em.find(Reserve.class, id);
    }

}
