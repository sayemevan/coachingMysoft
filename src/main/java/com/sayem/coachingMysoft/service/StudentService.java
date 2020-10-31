
package com.sayem.coachingMysoft.service;

import com.sayem.coachingMysoft.model.Students;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    
    public List<Students> viewAllStudent();
    
    public List<Students> viewAllMaleStudent();
    
    public List<Students> viewAllFemaleStudent();
    
    public Students viewOneStudent(int student_id);

    public Students saveStudent(Students students);
    
    public void updateStudent(Students students);

    public void deleteStudent(int student_id);
    
    public Long totalStudent();

    
}
