/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.coachingMysoft.service;

import com.sayem.coachingMysoft.model.Studentpayment;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface StudentPaymentService {
   
    public List<Studentpayment> viewAllStudentpayment();
    
    public Studentpayment viewOneStudentpayment(int spId);

    public Studentpayment saveStudentpayment(Studentpayment studentPayment);
    
    public void updateStudentpayment(Studentpayment studentPayment);

    public void deleteStudentpayment(int spId);
    
    public Double getTotalStudentpayment();

    
}
