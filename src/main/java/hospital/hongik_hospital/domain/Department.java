package hospital.hongik_hospital.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;
@Entity
@Getter @Setter
public class Department {
    public Department(String departname, Hospital hospital) {
        this.departname = departname;
        this.hospital = hospital;
    }
    protected Department() {
    }

    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String departname;

    @ManyToOne(fetch = LAZY,cascade =  CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "department")
    private List<Doctor> doctorList = new ArrayList<>();


    public static Department createDepartment(Doctor doctor) {
       Department department = new Department();
       department.getDoctorList().add(doctor);
       return department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "doctorList=" + doctorList +
                '}';
    }
}
