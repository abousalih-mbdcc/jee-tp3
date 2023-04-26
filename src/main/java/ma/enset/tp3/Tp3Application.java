package ma.enset.tp3;

import ma.enset.tp3.entities.Patient;
import ma.enset.tp3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Tp3Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Kamal", new Date(), false, 20));
        patientRepository.save(new Patient(null, "Said", new Date(), false, 200));
        patientRepository.save(Patient.builder()
                .id(null)
                .nom("Houda")
                .dateNaissance(new Date())
                .malade(true)
                .score(230)
                .build());

        patientRepository.findAll().forEach(System.out::println);
    }
}
