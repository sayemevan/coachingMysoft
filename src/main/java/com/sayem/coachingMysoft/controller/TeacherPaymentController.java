
package com.sayem.coachingMysoft.controller;

import com.sayem.coachingMysoft.model.Teacherpayment;
import com.sayem.coachingMysoft.service.TeacherPaymentService;
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
public class TeacherPaymentController {
    
    @Autowired
    TeacherPaymentService teacherPaymentService;
    
    @GetMapping("/teacherpayment")
    public List<Teacherpayment> getAllTeacherpayment(){
        return teacherPaymentService.viewAllTeacherpayment();
    }
    
    @GetMapping("/teacherpayment/total")
    public Double getTotalTeacherpayment(){
        return teacherPaymentService.getTotalTeacherpayment();
    }
    
    @GetMapping("/teacherpayment/{tp_id}")
    public ResponseEntity<Teacherpayment> getOneTeacherpayment(@PathVariable("sp_id") int tp_id){
        Teacherpayment teacherPayment = teacherPaymentService.viewOneTeacherpayment(tp_id);
        if (teacherPayment == null){
            return new ResponseEntity<Teacherpayment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Teacherpayment>(teacherPayment, HttpStatus.OK);
    }
    
    @PostMapping("/teacherpayment")
    public Teacherpayment createTeacherpayment(@RequestBody Teacherpayment teacherPayment){
        return teacherPaymentService.saveTeacherpayment(teacherPayment);
    }
    
    @PutMapping("/teacherpayment/{tp_id}")
    public ResponseEntity<Teacherpayment> updateTeacherpayment(@PathVariable("tp_id") int tp_id, @RequestBody Teacherpayment teacherPayment){
        
        Teacherpayment currentTeacherPayment = teacherPaymentService.viewOneTeacherpayment(tp_id);
        
        if (currentTeacherPayment == null){
            return new ResponseEntity<Teacherpayment>(HttpStatus.NOT_FOUND);
        }
        
        currentTeacherPayment.setTeachers(teacherPayment.getTeachers());
        currentTeacherPayment.setAmount(teacherPayment.getAmount());
        currentTeacherPayment.setPaymentDate(teacherPayment.getPaymentDate());
        
        teacherPaymentService.updateTeacherpayment(currentTeacherPayment);
        
        return new ResponseEntity<Teacherpayment>(currentTeacherPayment, HttpStatus.OK);
    }
    
    @DeleteMapping("/teacherpayment/{tp_id}")
    public ResponseEntity<Teacherpayment> deleteTeacherpayment(@PathVariable("tp_id") int tp_id){
        Teacherpayment teacherPayment = teacherPaymentService.viewOneTeacherpayment(tp_id);
        if (teacherPayment == null){
            return new ResponseEntity<Teacherpayment>(HttpStatus.NOT_FOUND);
        }
        teacherPaymentService.deleteTeacherpayment(tp_id);
        
        return new ResponseEntity<Teacherpayment>(HttpStatus.NO_CONTENT);
    }
}
