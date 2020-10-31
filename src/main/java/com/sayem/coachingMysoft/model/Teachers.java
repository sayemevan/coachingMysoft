package com.sayem.coachingMysoft.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Teachers {

     private Integer teacherId;
     private String teacherName;
     private String gender;
     private String subjectName;
     private String email;
     private Date joiningDate;

    public Teachers() {
    }

	
    public Teachers(String teacherName, String gender, String subjectName, String email, Date joiningDate) {
        this.teacherName = teacherName;
        this.gender = gender;
        this.subjectName = subjectName;
        this.email = email;
        this.joiningDate = joiningDate;
    }

   
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="teacher_id", unique=true, nullable=false)
    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    
    @Column(name="teacher_name", nullable=false, length=45)
    public String getTeacherName() {
        return this.teacherName;
    }
    
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    
    @Column(name="gender", nullable=false, length=45)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    @Column(name="subject_name", nullable=false, length=45)
    public String getSubjectName() {
        return this.subjectName;
    }
    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    
    @Column(name="email", nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="joining_date", nullable=false)
    public Date getJoiningDate() {
        return this.joiningDate;
    }
    
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

}


