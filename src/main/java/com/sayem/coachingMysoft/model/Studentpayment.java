package com.sayem.coachingMysoft.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table
public class Studentpayment implements java.io.Serializable{


     private Integer spId;
     private Students students;
     private double amount;
     private Date paymentDate;

    public Studentpayment() {
    }

    public Studentpayment(Students students, double amount, Date paymentDate) {
       this.students = students;
       this.amount = amount;
       this.paymentDate = paymentDate;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="sp_id", unique=true, nullable=false)
    public Integer getSpId() {
        return this.spId;
    }
    
    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="student_id", nullable=false)
    public Students getStudents() {
        return this.students;
    }
    
    public void setStudents(Students students) {
        this.students = students;
    }

    
    @Column(name="amount", nullable=false, precision=22, scale=0)
    public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="payment_date", nullable=false, length=10)
    public Date getPaymentDate() {
        return this.paymentDate;
    }
    
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

}


