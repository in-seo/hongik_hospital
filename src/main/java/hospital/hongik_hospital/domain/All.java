package hospital.hongik_hospital.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "allreserve")
@Getter @Setter
@NoArgsConstructor//(access = AccessLevel.PROTECTED)
public class All {

    @Id
    @GeneratedValue  //예약 전체 출력용!!!!
    @Column(name = "all_id")
    private Long id;

    private String Hospital;

    private String patientName;

    private LocalDateTime time;

    private String Doctor;

    private String department;


}