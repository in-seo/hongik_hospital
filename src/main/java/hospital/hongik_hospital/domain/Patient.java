package hospital.hongik_hospital.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor//(access = AccessLevel.PROTECTED)
public class Patient {
        public Patient(String username, int age, Gender gender) {
                this.username = username;
                this.age = age;
                this.gender = gender;
        }

        @Id
        @GeneratedValue
        @Column(name = "patient_id")
        private Long id;

        private String username;

        private int age;

        @Enumerated(EnumType.STRING)  //맞겠지..?
        private Gender gender;

        public enum Gender {Male, Female}


        @OneToMany(mappedBy = "patient")
        private List<Reserve> reserveList = new ArrayList<>();  //환자의 예약정보 나열가능

}




