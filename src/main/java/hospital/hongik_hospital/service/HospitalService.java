package hospital.hongik_hospital.service;

import hospital.hongik_hospital.domain.*;
import hospital.hongik_hospital.repository.AllRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class HospitalService {

    private final AllRepository allRepository;

    @Transactional
    public void create(Reserve reserve, Doctor doctor){
        All all = new All();
        all.setTime(reserve.getReserveTime());  //시간
        all.setPatientName(reserve.getPatient().getUsername()); //환자이름
        all.setDoctor(doctor.getDoctorname());  //의사이름
        all.setDepartment(doctor.getDepartment().getDepartname()); //진료과
        all.setHospital(doctor.getDepartment().getHospital().getHosName()); //진료병원
        allRepository.save(all);
    }
}
