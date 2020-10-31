
package com.sayem.coachingMysoft.repository;

import com.sayem.coachingMysoft.model.Teachers;
import com.sayem.coachingMysoft.service.TeacherService;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TeacherRepository implements TeacherService{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public List<Teachers> viewAllTeacher() {
        
        Session session = sessionFactory.getCurrentSession();
        List<Teachers> teacherList = session.createQuery("from Teachers").list();
        
        return teacherList;
    }

    @Override
    public Teachers viewOneTeacher(int teacher_id) {
        
        Session session = sessionFactory.getCurrentSession();
        Teachers teacher = (Teachers)session.get(Teachers.class, teacher_id);

        return teacher;
    }

    @Override
    public Teachers saveTeacher(Teachers teachers) {
        
        Session session = sessionFactory.getCurrentSession();
        session.save(teachers);
        
        return teachers;
    }

    @Override
    public void updateTeacher(Teachers teachers) {
        Session session = sessionFactory.getCurrentSession();
        session.update(teachers);
    }

    @Override
    public void deleteTeacher(int teacher_id) {
        Session session = sessionFactory.getCurrentSession();
        Teachers teacher = (Teachers)session.get(Teachers.class, teacher_id);
        session.delete(teacher);
    }

    @Override
    public Long totalTeacher() {
        Session session = sessionFactory.getCurrentSession();
        Query totalTeacher = session.createQuery("select count(*) from Teachers t");
        
        for(Iterator it=totalTeacher.iterate(); it.hasNext();) {
            Long countTeacher = (Long) it.next();
            
            return countTeacher;
        }

        return null;
    }
    
}
