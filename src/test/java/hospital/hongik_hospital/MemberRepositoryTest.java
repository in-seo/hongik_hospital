package hospital.hongik_hospital;


import hospital.hongik_hospital.domain.Patient;

import hospital.hongik_hospital.repository.PatientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    PatientRepository patientRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void 저장() {
        Patient patient = new Patient();
        patient.setUsername("송인서");
        patient.setGender(Patient.Gender.Male);
        Assertions.assertThat(patient.getGender()).isEqualTo(Patient.Gender.Male);
        Long pId = patientRepository.save(patient);
        Assertions.assertThat(pId).isEqualTo(1L);
    }


}
