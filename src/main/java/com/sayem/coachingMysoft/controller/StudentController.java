
package com.sayem.coachingMysoft.controller;

import com.sayem.coachingMysoft.model.Students;
import com.sayem.coachingMysoft.service.StudentService;
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
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    @GetMapping("/students")
    public List<Students> getAllStudents(){
        return studentService.viewAllStudent();
    }
    
    @GetMapping("/students/total")
    public Long getTotalStudents(){
        return studentService.totalStudent();
    }
    
    @GetMapping("/students/male")
    public List<Students> getAllMaleStudents(){
        return studentService.viewAllMaleStudent();
    }
    
    @GetMapping("/students/female")
    public List<Students> getAllFemaleStudents(){
        return studentService.viewAllFemaleStudent();
    }
    
    @GetMapping("/students/{student_id}")
    public ResponseEntity<Students> getOneStudent(@PathVariable("student_id") int student_id){
        Students student = studentService.viewOneStudent(student_id);
        if (student == null){
            return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Students>(student, HttpStatus.OK);
    }
    
    @PostMapping("/students")
    public Students createStudent(@RequestBody Students student){
        return studentService.saveStudent(student);
    }
    
    @PutMapping("/students/{student_id}")
    public ResponseEntity<Students> updateStudent(@PathVariable("student_id") int student_id, @RequestBody Students student){
        
        Students currentStudent = studentService.viewOneStudent(student_id);
        
        if (currentStudent == null){
            return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        }
        
        currentStudent.setStudent_name(student.getStudent_name());
        currentStudent.setDob(student.getDob());
        currentStudent.setGender(student.getGender());
        currentStudent.setRunning_class(student.getRunning_class());
        currentStudent.setGroupsub(student.getGroupsub());
        currentStudent.setBatch(student.getBatch());
        
        studentService.updateStudent(currentStudent);
        
        return new ResponseEntity<Students>(currentStudent, HttpStatus.OK);
    }
    
    @DeleteMapping("/students/{student_id}")
    public ResponseEntity<Students> deleteStudent(@PathVariable("student_id") int student_id){
        Students student = studentService.viewOneStudent(student_id);
        if (student == null){
            return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudent(student_id);
        return new ResponseEntity<Students>(HttpStatus.NO_CONTENT);
    }
    
}
