package hospital.hongik_hospital.repository;

import hospital.hongik_hospital.domain.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class PatientRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional  //들어가야되나?
    public Long save(Patient patient) {
        em.persist(patient);
        return patient.getId();
    }
    public Patient findById(Long id) {
        return em.find(Patient.class, id);
    }
}