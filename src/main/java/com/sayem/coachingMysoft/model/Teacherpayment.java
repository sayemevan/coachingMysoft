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
public class Teacherpayment  implements java.io.Serializable {


     private Integer tpId;
     private Teachers teachers;
     private double amount;
     private Date paymentDate;

    public Teacherpayment() {
    }

    public Teacherpayment(Teachers teachers, double amount, Date paymentDate) {
       this.teachers = teachers;
       this.amount = amount;
       this.paymentDate = paymentDate;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="tp_id", unique=true, nullable=false)
    public Integer getTpId() {
        return this.tpId;
    }
    
    public void setTpId(Integer tpId) {
        this.tpId = tpId;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="teacher_id", nullable=false)
    public Teachers getTeachers() {
        return this.teachers;
    }
    
    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
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


