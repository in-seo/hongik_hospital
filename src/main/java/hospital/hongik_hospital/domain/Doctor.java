package hospital.hongik_hospital.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;


@Entity
@Getter @Setter
@NoArgsConstructor//(access = AccessLevel.PROTECTED)
public class Doctor {
    public Doctor(String doctorname, String phonenumber, int career, Department department) {
        this.doctorname = doctorname;
        this.phonenumber = phonenumber;
        this.career = career;
        this.department = department;
    }

    @Id
    @GeneratedValue
    @Column(name = "doctor_id")
    private Long id;

    private String doctorname;

    private String phonenumber;

    private int career;

    @ManyToOne(fetch = LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "doctor")
    private List<Reserve> reserveList = new ArrayList<>();  //환자의 예약정보 나열가능

    public Doctor createDoctor(Department department) {
        Doctor doctor = new Doctor();
        doctor.setDepartment(department);
        doctor.setDoctorname(doctor.getDoctorname());
        doctor.setPhonenumber(doctor.getPhonenumber());
        doctor.setCareer(doctor.getCareer());
        this.department.getDoctorList().add(doctor);
        return doctor;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctorname='" + doctorname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", career=" + career +
                '}';
    }
}
