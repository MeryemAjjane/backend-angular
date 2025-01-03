package org.event.springangular.dtos;


import org.event.springangular.entities.PayementStatus;
import org.event.springangular.entities.PayementType;

import java.time.LocalDate;


public class NewPayementDTO {

   private double amount;
   private PayementType type;
   private PayementStatus status;
   private LocalDate date;
   private String studentCode;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public NewPayementDTO(double amount, PayementType type, PayementStatus status, LocalDate date, String studentCode) {
        this.amount = amount;
        this.type = type;
        this.status=status;
        this.date = date;
        this.studentCode = studentCode;
    }
    public NewPayementDTO() {}
}

