
package com.sayem.coachingMysoft.service;

import com.sayem.coachingMysoft.model.Teachers;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    
    public List<Teachers> viewAllTeacher();
    
    public Teachers viewOneTeacher(int teacher_id);

    public Teachers saveTeacher(Teachers teachers);
    
    public void updateTeacher(Teachers teachers);

    public void deleteTeacher(int teacher_id);
    
    public Long totalTeacher();
    
}
