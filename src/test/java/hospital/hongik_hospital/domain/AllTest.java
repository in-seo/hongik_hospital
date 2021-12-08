package hospital.hongik_hospital.domain;

import hospital.hongik_hospital.repository.DepartmentRepository;
import hospital.hongik_hospital.repository.DoctorRepository;
import hospital.hongik_hospital.repository.PatientRepository;
import hospital.hongik_hospital.repository.ReserveRepository;
import hospital.hongik_hospital.service.DoctorService;
import hospital.hongik_hospital.service.HospitalService;
import hospital.hongik_hospital.service.ReserveService;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllTest {
    @Autowired ReserveService reserveService;
    @Autowired HospitalService hospitalService;
    @Autowired ReserveRepository reserveRepository;
    @Autowired PatientRepository patientRepository;
    @Autowired DoctorRepository doctorRepository;
    @Autowired DoctorService doctorService;
    @Autowired DepartmentRepository departmentRepository;


    @Test
    @Transactional
    @Rollback(value = false)
    public void 병원및진료과() {
        Hospital hospital1 = new Hospital("외과병원", new Address("Anyang", "Pyeongchon", "Apartment"));
        Department department = new Department("외 과", hospital1);
        departmentRepository.save(department);
        Hospital hospital2 = new Hospital("서울아산병원", new Address("Seoul", "Songpa", "poongra"));
        Department department2 = new Department("이비인후과",hospital2);
        departmentRepository.save(department2);
        Hospital hospital3 = new Hospital("신경외과의원", new Address("Seoul", "Sinchon", "hong"));
        Department department3 = new Department("신경외과",hospital3);
        departmentRepository.save(department3);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void 의사및환자() {
        Doctor seongwook = new Doctor("유성욱", "010-1234-9876", 27, null); doctorRepository.save(seongwook);
        doctorService.MakeDocter(seongwook.getId(), departmentRepository.findById(1L)); //이름으로 검색해보기
        Patient inseo = new Patient("송인서",22, Patient.Gender.Male); patientRepository.save(inseo);
        Long aLong = reserveService.Reserve(inseo.getId(), seongwook.getId());
        hospitalService.create(reserveRepository.getOne(aLong),seongwook);

        Doctor hyunwoo = new Doctor("송현우", "010-2235-2121", 8, null); doctorRepository.save(hyunwoo);
        doctorService.MakeDocter(hyunwoo.getId(), departmentRepository.findById(3L));
        Patient hoyeon = new Patient("이호연",18, Patient.Gender.Female); patientRepository.save(hoyeon);
        Long aLong1 = reserveService.Reserve(hoyeon.getId(), hyunwoo.getId());
        hospitalService.create(reserveRepository.getOne(aLong1),hyunwoo);

        Doctor Taemin = new Doctor("김태민", "010-7444-3236", 11, null); doctorRepository.save(Taemin);
        doctorService.MakeDocter(Taemin.getId(), departmentRepository.findById(5L));
        Patient Nayeon = new Patient("이나연",43, Patient.Gender.Female); patientRepository.save(Nayeon);
        Long aLong2 = reserveService.Reserve(Nayeon.getId(), Taemin.getId());
        hospitalService.create(reserveRepository.getOne(aLong2),Taemin);

        Doctor Habin = new Doctor("강하빈", "010-1231-6231", 17, null); doctorRepository.save(Habin);
        doctorService.MakeDocter(Habin.getId(), departmentRepository.findById(1L));
        Patient Mingi = new Patient("서민기",33, Patient.Gender.Male); patientRepository.save(Mingi);
        Long aLong3 = reserveService.Reserve(Mingi.getId(), Habin.getId());
        hospitalService.create(reserveRepository.getOne(aLong3),Habin);

        Doctor seoungchan = new Doctor("김승찬", "031-433-1221", 6, null); doctorRepository.save(seoungchan);
        doctorService.MakeDocter(seoungchan.getId(), departmentRepository.findById(1L));
        Patient seadg = new Patient("홍석천",33, Patient.Gender.Male); patientRepository.save(seadg);
        Long aLong4 = reserveService.Reserve(seadg.getId(), seoungchan.getId());
        hospitalService.create(reserveRepository.getOne(aLong4),seoungchan);

        Doctor agj = new Doctor("조민", "031-433-1221", 6, null); doctorRepository.save(agj);
        doctorService.MakeDocter(agj.getId(), departmentRepository.findById(3L));
        Patient alkga = new Patient("김준환",33, Patient.Gender.Male); patientRepository.save(alkga);
        Long dd = reserveService.Reserve(alkga.getId(), agj.getId());
        hospitalService.create(reserveRepository.getOne(dd),agj);

        Long song = reserveService.Reserve(patientRepository.findById(8L).getId(), agj.getId());
        hospitalService.create(reserveRepository.getOne(song),agj);
    }


    @PersistenceUnit
    public EntityManagerFactory factory;

    @Test
    @Transactional
    @Rollback(value = false)
    public void 진료과_의사정보출력() {
        EntityManager em = factory.createEntityManager();
        List result = em.createQuery("select distinct d from Department d join d.doctorList")
                .getResultList();
        System.out.println("result = " + result);
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void 환자_예약정보출력() {
        EntityManager em = factory.createEntityManager();
        List<Object[]> resultList = em.createQuery("select p.username, r.doctor.doctorname from Patient p join p.reserveList r")
                .getResultList();
        Object[] result = resultList.get(0);
        for (Object o : result) {
            System.out.println("result[0]+result[1] = " + result[0] + result[1]);
        }


    }




}
