package hospital.hongik_hospital.repository;

import hospital.hongik_hospital.domain.Doctor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DoctorRepository{
    @PersistenceContext
    EntityManager em;

    @Transactional
    public Long save(Doctor doctor) {
        em.persist(doctor);
        return doctor.getId();
    }
    public Doctor findById(Long id) {
        return em.find(Doctor.class, id);
    }
}
