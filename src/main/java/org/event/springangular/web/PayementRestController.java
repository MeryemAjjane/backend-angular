package org.event.springangular.web;

import org.event.springangular.dtos.NewPayementDTO;
import org.event.springangular.entities.Payement;
import org.event.springangular.entities.PayementStatus;
import org.event.springangular.entities.PayementType;
import org.event.springangular.entities.Student;
import org.event.springangular.repository.PayementRepository;
import org.event.springangular.repository.StudentRepository;
import org.event.springangular.services.PayementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class PayementRestController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PayementRepository payementRepository;
    @Autowired
    PayementService payementService;
    public PayementRestController(StudentRepository studentRepository, PayementRepository payementRepository) {
        this.studentRepository=studentRepository;
        this.payementRepository=payementRepository;
        this.payementService=payementService;
}
   @GetMapping(path="/payements")
   public List<Payement> allPayements(){
            return payementRepository.findAll();
   }
    @GetMapping(path="/student-details/{code}")
    public List<Payement> PayementsByStudent(@PathVariable String code){
        return payementRepository.findByStudentCode(code);
    }
    @GetMapping(path="/payements/byStatus")
    public List<Payement> PayementsByStatus(@RequestParam PayementStatus status){
        return payementRepository.findByStatus(status);
    }
    @GetMapping(path="/payements/byType")
    public List<Payement> PayementsByType(@RequestParam PayementType type){
        return payementRepository.findByType(type);
    }
   @GetMapping(path="/payements/{id}")
   public Payement getPayementById(@PathVariable Long id){
        return payementRepository.findById(id).get();
   }
    @GetMapping(path="/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }
    @GetMapping(path="/students/{code}")
    public Student getStudentByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
    }
    @GetMapping(path="/studentsByProgramId")
    public List<Student> getStudentByProgramId(@RequestParam String programId){
        return studentRepository.findByProgramId(programId);
    }
    @PostMapping("/payements/{id}")
    public Payement updatepayement(@RequestParam PayementStatus payementStatus,@PathVariable Long id){

        return this.payementService.updatepayement(payementStatus,id);
    }
    @PostMapping(path ="/payements",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payement savePayement(@RequestParam("file") MultipartFile file, NewPayementDTO newPayementDTO) throws IOException {

        return this.payementService.savePayement(file,newPayementDTO);
    }
    @GetMapping(path ="/payementFile/{payementId}",produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPayementFile(@PathVariable Long payementId) throws IOException {
         return this.payementService.getPayementFile(payementId);
    }

}
