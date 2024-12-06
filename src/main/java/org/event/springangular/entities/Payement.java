package org.event.springangular.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity @ToString
@Getter @Setter
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private PayementType type;
    private PayementStatus status;
    private String file;
    @ManyToOne
    private Student student;

    public Payement(LocalDate date, double amount, PayementType type, PayementStatus status, Student student) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.student = student;
    }

    public Payement() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PayementType getType() {
        return type;
    }

    public void setType(PayementType type) {
        this.type = type;
    }

    public PayementStatus getStatus() {
        return status;
    }

    public void setStatus(PayementStatus status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
