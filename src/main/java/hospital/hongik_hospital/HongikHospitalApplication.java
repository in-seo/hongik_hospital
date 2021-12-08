package hospital.hongik_hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class HongikHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HongikHospitalApplication.class, args);
	}

}
