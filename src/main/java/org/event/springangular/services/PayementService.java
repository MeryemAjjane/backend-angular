package org.event.springangular.services;

import org.event.springangular.entities.Payement;
import org.event.springangular.entities.PayementStatus;
import org.event.springangular.entities.PayementType;
import org.event.springangular.entities.Student;
import org.event.springangular.repository.PayementRepository;
import org.event.springangular.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class PayementService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PayementRepository payementRepository;

    public PayementService(StudentRepository studentRepository, PayementRepository payementRepository) {
        this.studentRepository = studentRepository;
        this.payementRepository = payementRepository;
    }
    public Payement savePayement(MultipartFile file, LocalDate date, double amount, PayementType type, String studentCode) throws IOException {
        Path folderPath= Paths.get(System.getProperty("user.home"),"mer-data","payements");
        if(!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName= UUID.randomUUID().toString();
        Path filePath=Paths.get(System.getProperty("user.home"),"mer-data","payements",fileName+".pdf");
        Files.copy(file.getInputStream(),filePath);
        Student student=studentRepository.findByCode(studentCode);
        Payement payement=new Payement();
        payement.setStudent(student);
        payement.setDate(date);
        payement.setAmount(amount);
        payement.setType(type);
        payement.setFile(filePath.toUri().toString());
        return payementRepository.save(payement);
    }
    public Payement updatepayement(PayementStatus payementStatus,Long id){
        Payement payement=payementRepository.findById(id).get();
        payement.setStatus(payementStatus);
        return payementRepository.save(payement);
    }
    public byte[] getPayementFile(Long payementId) throws IOException {
        Payement payement=payementRepository.findById(payementId).get();
        return Files.readAllBytes(Path.of(URI.create(payement.getFile())));
    }
}
