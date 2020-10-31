
package com.sayem.coachingMysoft.service;

import com.sayem.coachingMysoft.model.Studentpayment;
import com.sayem.coachingMysoft.model.Teacherpayment;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TeacherPaymentService {
    
    public List<Teacherpayment> viewAllTeacherpayment();
    
    public Teacherpayment viewOneTeacherpayment(int tpId);

    public Teacherpayment saveTeacherpayment(Teacherpayment teacherPayment);
    
    public void updateTeacherpayment(Teacherpayment teacherPayment);

    public void deleteTeacherpayment(int tpId);
    
    public Double getTotalTeacherpayment();
    
}
