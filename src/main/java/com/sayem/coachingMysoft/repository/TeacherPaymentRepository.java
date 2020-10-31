
package com.sayem.coachingMysoft.repository;

import com.sayem.coachingMysoft.model.Teacherpayment;
import com.sayem.coachingMysoft.service.TeacherPaymentService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TeacherPaymentRepository implements TeacherPaymentService{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public List<Teacherpayment> viewAllTeacherpayment() {
        
        Session session = sessionFactory.getCurrentSession();
        List<Teacherpayment> teacherpaymentList = session.createQuery("from Teacherpayment").list();
        
        return teacherpaymentList;
    }

    @Override
    public Teacherpayment viewOneTeacherpayment(int tpId) {
        
        Session session = sessionFactory.getCurrentSession();
        Teacherpayment teacherPayment = (Teacherpayment)session.get(Teacherpayment.class, tpId);

        return teacherPayment;
    }

    @Override
    public Teacherpayment saveTeacherpayment(Teacherpayment teacherPayment) {
        
        Session session = sessionFactory.getCurrentSession();
        session.save(teacherPayment);
        
        return teacherPayment;
    }

    @Override
    public void updateTeacherpayment(Teacherpayment teacherPayment) {
        Session session = sessionFactory.getCurrentSession();
        session.update(teacherPayment);
    }

    @Override
    public void deleteTeacherpayment(int tpId) {
        Session session = sessionFactory.getCurrentSession();
        Teacherpayment teacherPayment = (Teacherpayment)session.get(Teacherpayment.class, tpId);
        session.delete(teacherPayment);
    }

    @Override
    public Double getTotalTeacherpayment() {
        
        Session session = sessionFactory.getCurrentSession();
        Double sumOfPayment = (Double) session.createQuery("SELECT sum(amount) from Teacherpayment").getSingleResult();
    
        return sumOfPayment;
    }
    
}
