package hospital.hongik_hospital.service;

import hospital.hongik_hospital.domain.Department;
import hospital.hongik_hospital.domain.Doctor;
import hospital.hongik_hospital.domain.Hospital;
import hospital.hongik_hospital.repository.DepartmentRepository;
import hospital.hongik_hospital.repository.DoctorRepository;
import hospital.hongik_hospital.repository.PatientRepository;
import hospital.hongik_hospital.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional
    public Doctor MakeDocter(Long doctorid,Department department){ //생성되어있는 의사와 진료과 결합
        Doctor doctor = doctorRepository.findById(doctorid);
        doctor.setDepartment(department);
        department.getDoctorList().add(doctor);
        doctorRepository.save(doctor);
        departmentRepository.save(department);
        return doctor;
    }


}
