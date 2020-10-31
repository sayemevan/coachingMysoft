
package com.sayem.coachingMysoft.controller;

import com.sayem.coachingMysoft.model.Teachers;
import com.sayem.coachingMysoft.service.TeacherService;
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
public class TeacherController {
    
    @Autowired
    TeacherService teacherService;
    
    @GetMapping("/teachers")
    public List<Teachers> getAllTeachers(){
        return teacherService.viewAllTeacher();
    }
    
    @GetMapping("/teachers/total")
    public Long getTotalTeachers(){
        return teacherService.totalTeacher();
    }
    
    @GetMapping("/teachers/{teacher_id}")
    public ResponseEntity<Teachers> getOneTeacher(@PathVariable("teacher_id") int teacher_id){
        Teachers teacher = teacherService.viewOneTeacher(teacher_id);
        if (teacher == null){
            return new ResponseEntity<Teachers>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Teachers>(teacher, HttpStatus.OK);
    }
    
    @PostMapping("/teachers")
    public Teachers createTeacher(@RequestBody Teachers teacher){
        return teacherService.saveTeacher(teacher);
    }
    
    @PutMapping("/teachers/{teacher_id}")
    public ResponseEntity<Teachers> updateTeacher(@PathVariable("teacher_id") int teacher_id, @RequestBody Teachers teacher){
        
        Teachers currentTeacher = teacherService.viewOneTeacher(teacher_id);
        
        if (currentTeacher == null){
            return new ResponseEntity<Teachers>(HttpStatus.NOT_FOUND);
        }
        
        currentTeacher.setTeacherName(teacher.getTeacherName());
        currentTeacher.setGender(teacher.getGender());
        currentTeacher.setSubjectName(teacher.getSubjectName());
        currentTeacher.setEmail(teacher.getEmail());
        currentTeacher.setJoiningDate(teacher.getJoiningDate());
        
        teacherService.updateTeacher(currentTeacher);
        
        return new ResponseEntity<Teachers>(currentTeacher, HttpStatus.OK);
    }
    
    @DeleteMapping("/teachers/{teacher_id}")
    public ResponseEntity<Teachers> deleteTeacher(@PathVariable("teacher_id") int teacher_id){
        Teachers teacher = teacherService.viewOneTeacher(teacher_id);
        if (teacher == null){
            return new ResponseEntity<Teachers>(HttpStatus.NOT_FOUND);
        }
        teacherService.deleteTeacher(teacher_id);
        return new ResponseEntity<Teachers>(HttpStatus.NO_CONTENT);
    }
    
}
