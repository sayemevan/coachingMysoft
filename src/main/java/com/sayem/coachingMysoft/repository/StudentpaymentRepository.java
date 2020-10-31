
package com.sayem.coachingMysoft.repository;

import com.sayem.coachingMysoft.model.Studentpayment;
import com.sayem.coachingMysoft.service.StudentPaymentService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentpaymentRepository implements StudentPaymentService {

    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public List<Studentpayment> viewAllStudentpayment() {
        
        Session session = sessionFactory.getCurrentSession();
        List<Studentpayment> studentPaymentList = session.createQuery("from Studentpayment").list();
        
        return studentPaymentList;
    }

    @Override
    public Studentpayment viewOneStudentpayment(int spId) {
        
        Session session = sessionFactory.getCurrentSession();
        Studentpayment studentPayment = (Studentpayment)session.get(Studentpayment.class, spId);

        return studentPayment;
    }

    @Override
    public Studentpayment saveStudentpayment(Studentpayment studentPayment) {
       
        Session session = sessionFactory.getCurrentSession();
        session.save(studentPayment);
        
        return studentPayment;
    }

    @Override
    public void updateStudentpayment(Studentpayment studentPayment) {
        Session session = sessionFactory.getCurrentSession();
        session.update(studentPayment);
    }

    @Override
    public void deleteStudentpayment(int spId) {
        Session session = sessionFactory.getCurrentSession();
        Studentpayment studentPayment = (Studentpayment)session.get(Studentpayment.class, spId);
        session.delete(studentPayment);
    }

    @Override
    public Double getTotalStudentpayment() {
        Session session = sessionFactory.getCurrentSession();
        Double sumOfPayment = (Double) session.createQuery("SELECT sum(amount) from Studentpayment").getSingleResult();
    
        return sumOfPayment;
    }
    
}
