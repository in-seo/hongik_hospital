package hospital.hongik_hospital.domain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter @Setter
public class Reserve {

    @Id
    @GeneratedValue
    @Column(name = "reserve_id")  //예약번호
    private Long id;

    @ManyToOne(fetch = LAZY,cascade =  CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = LAZY,cascade =  CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    @Enumerated(EnumType.STRING)
    private ReserveStatus reserveStatus;

    private LocalDateTime reserveTime;


    public static Reserve createReserve(Patient Who,Doctor doctor) {
        Reserve reserve = new Reserve();
        reserve.setReserveStatus(ReserveStatus.RESERVE);
        reserve.reserveTime = LocalDateTime.now(); // 일단 현 시간으로
        reserve.setPatient(Who);
        reserve.setDoctor(doctor);
        return reserve;
    } //나중에 다른애들 넣어주면 됌  reserveService에서  의사이름, 환자이름으로 바꿔버리자

    private void setPatient(Patient patient){
        this.patient = patient;
        patient.getReserveList().add(this);
    }

    private void setDoctor(Doctor doctor){
        this.doctor = doctor;
        doctor.getReserveList().add(this);
    }

    public void cancel(Reserve reserve) {
        reserve.setReserveStatus(ReserveStatus.CANCEL);
        reserve.reserveTime = null;
    }


}
