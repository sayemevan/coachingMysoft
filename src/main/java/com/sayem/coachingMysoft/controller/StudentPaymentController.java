
package com.sayem.coachingMysoft.controller;

import com.sayem.coachingMysoft.model.Studentpayment;
import com.sayem.coachingMysoft.service.StudentPaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/coaching/api/v1")
public class StudentPaymentController {
    
    @Autowired
    StudentPaymentService studentPaymentService;
    
    @GetMapping("/studentpayment")
    public List<Studentpayment> getAllStudentpayment(){
        return studentPaymentService.viewAllStudentpayment();
    }
    
    @GetMapping("/studentpayment/total")
    public Double getTotalStudentpayment(){
        return studentPaymentService.getTotalStudentpayment();
    }
    
    @GetMapping("/studentpayment/{sp_id}")
    public ResponseEntity<Studentpayment> getOneStudentpayment(@PathVariable("sp_id") int sp_id){
        Studentpayment studentPayment = studentPaymentService.viewOneStudentpayment(sp_id);
        if (studentPayment == null){
            return new ResponseEntity<Studentpayment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Studentpayment>(studentPayment, HttpStatus.OK);
    }
    
    @PostMapping("/studentpayment")
    public Studentpayment createStudentpayment(@RequestBody Studentpayment studentPaymentt){
        return studentPaymentService.saveStudentpayment(studentPaymentt);
    }
    
    @PutMapping("/studentpayment/{sp_id}")
    public ResponseEntity<Studentpayment> updateStudentpayment(@PathVariable("sp_id") int sp_id, @RequestBody Studentpayment studentPayment){
        
        Studentpayment currentstudentPayment = studentPaymentService.viewOneStudentpayment(sp_id);
        
        if (currentstudentPayment == null){
            return new ResponseEntity<Studentpayment>(HttpStatus.NOT_FOUND);
        }
        
        currentstudentPayment.setStudents(studentPayment.getStudents());
        currentstudentPayment.setAmount(studentPayment.getAmount());
        currentstudentPayment.setPaymentDate(studentPayment.getPaymentDate());
        
        studentPaymentService.updateStudentpayment(currentstudentPayment);
        
        return new ResponseEntity<Studentpayment>(currentstudentPayment, HttpStatus.OK);
    }
    
    @DeleteMapping("/studentpayment/{sp_id}")
    public ResponseEntity<Studentpayment> deleteStudentpayment(@PathVariable("sp_id") int sp_id){
        Studentpayment studentPayment = studentPaymentService.viewOneStudentpayment(sp_id);
        if (studentPayment == null){
            return new ResponseEntity<Studentpayment>(HttpStatus.NOT_FOUND);
        }
        studentPaymentService.deleteStudentpayment(sp_id);
        
        return new ResponseEntity<Studentpayment>(HttpStatus.NO_CONTENT);
    }
    
}
