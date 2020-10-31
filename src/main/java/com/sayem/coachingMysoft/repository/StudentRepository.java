/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.coachingMysoft.repository;

import com.sayem.coachingMysoft.model.Students;
import com.sayem.coachingMysoft.service.StudentService;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class StudentRepository implements StudentService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Students> viewAllStudent() {
        
        Session session = sessionFactory.getCurrentSession();
        List<Students> studentList = session.createQuery("from Students").list();
        
        return studentList;
    }

    @Override
    public Students viewOneStudent(int student_id) {
        
        Session session = sessionFactory.getCurrentSession();
        Students student = (Students)session.get(Students.class, student_id);

        return student;
    }

    @Override
    public Students saveStudent(Students students) {
        
        Session session = sessionFactory.getCurrentSession();
        session.save(students);
        
        return students;
    }

    @Override
    public void updateStudent(Students students) {
        
        Session session = sessionFactory.getCurrentSession();
        session.update(students);
        
    }

    @Override
    public void deleteStudent(int student_id) {
        
        Session session = sessionFactory.getCurrentSession();
        Students student = (Students)session.get(Students.class, student_id);
        session.delete(student);
        
    }

    @Override
    public List<Students> viewAllMaleStudent() {
        
        Session session = sessionFactory.getCurrentSession();
        List<Students> maleStudentList = session.createQuery("select ms from Students ms where ms.gender='Male'").list();

        return maleStudentList;
    }

    @Override
    public List<Students> viewAllFemaleStudent() {
        Session session = sessionFactory.getCurrentSession();
        List<Students> femaleStudentList = session.createQuery("select ms from Students ms where ms.gender='Female'").list();

        return femaleStudentList;
    }

    @Override
    public Long totalStudent() {
        Session session = sessionFactory.getCurrentSession();
        Query totalStudent = session.createQuery("select count(*) from Students s");
        
        for(Iterator it=totalStudent.iterate(); it.hasNext();) {
            Long countStudent = (Long) it.next();
            
            return countStudent;
        }

        return null;
    }
    
}
