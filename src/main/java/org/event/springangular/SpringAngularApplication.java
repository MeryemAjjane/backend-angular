package org.event.springangular;

import org.event.springangular.entities.Payement;
import org.event.springangular.entities.PayementStatus;
import org.event.springangular.entities.PayementType;
import org.event.springangular.entities.Student;
import org.event.springangular.repository.PayementRepository;
import org.event.springangular.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class SpringAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAngularApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PayementRepository payementRepository) {
//        return args -> {
//            // Création des étudiants
//            studentRepository.save(new Student(UUID.randomUUID().toString(), "Meryem", "nnn", "1234564", "SDIA", "ph1"));
//            studentRepository.save(new Student(UUID.randomUUID().toString(), "Fatima", "nnn2", "545589", "GIGD", "ph2"));
//            studentRepository.save(new Student(UUID.randomUUID().toString(), "Youssef", "nnn3", "234568", "BCCC", "ph3"));
//            studentRepository.save(new Student(UUID.randomUUID().toString(), "Nassoma", "nnn4", "900888", "GIOP", "ph4"));
//
//            // Création des paiements aléatoires pour chaque étudiant
//            PayementType[] payementTypes = PayementType.values();
//            Random random = new Random();
//
//            studentRepository.findAll().forEach(student -> {
//                for (int i = 0; i < 10; i++) {
//                    int index = random.nextInt(payementTypes.length);
//                    Payement payement = new Payement(LocalDate.now(),1000 + (int) (Math.random() * 20000),payementTypes[index],PayementStatus.CREATED,student);
//                    payementRepository.save(payement);
//                }
//            });
//        };
//    }
}
