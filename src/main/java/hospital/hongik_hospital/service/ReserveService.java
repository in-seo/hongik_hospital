package hospital.hongik_hospital.service;

import hospital.hongik_hospital.domain.Doctor;
import hospital.hongik_hospital.domain.Patient;
import hospital.hongik_hospital.domain.Reserve;
import hospital.hongik_hospital.repository.DoctorRepository;
import hospital.hongik_hospital.repository.PatientRepository;
import hospital.hongik_hospital.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReserveService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final ReserveRepository reserveRepository;


    public Long Reserve(Long Patientid, Long Doctorid){
        Patient patient = patientRepository.findById(Patientid);
        Doctor doctor = doctorRepository.findById(Doctorid);
        Reserve saved = reserveRepository.save(Reserve.createReserve(patient, doctor));
        return saved.getId();
    }
}
