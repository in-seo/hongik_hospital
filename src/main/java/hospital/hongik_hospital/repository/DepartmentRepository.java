package hospital.hongik_hospital.repository;

import hospital.hongik_hospital.domain.Department;
import hospital.hongik_hospital.domain.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository{

    public final EntityManager em;

    @Transactional
    public Long save(Department department) {
        em.persist(department);
        return department.getId();
    }

    public List<Doctor> findBydepartname(String name){
        return em.createQuery("select d from Doctor d where d.department = :department",Doctor.class)
                .setParameter("department",name)
                .getResultList();
    }

    public Department findById(Long id) {
        return em.find(Department.class, id);
    }

}
