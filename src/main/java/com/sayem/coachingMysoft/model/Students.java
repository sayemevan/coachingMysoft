
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
public class Students {
  
    private Integer student_id;
    private String student_name;
    private String gender;
    private Date dob;
    private String running_class;
    private String groupsub;
    private String batch;

    public Students() {
    }

    public Students(String student_name, String gender, Date dob, String running_class, String groupsub, String batch) {
        this.student_name = student_name;
        this.gender = gender;
        this.dob = dob;
        this.running_class = running_class;
        this.groupsub = groupsub;
        this.batch = batch;
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="student_id", unique=true, nullable=false)
    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    @Column(name="student_name", nullable=false)
    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    @Column(name="gender", nullable=false)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dob", nullable=false)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(name="running_class", nullable=false)
    public String getRunning_class() {
        return running_class;
    }

    
    public void setRunning_class(String running_class) {
        this.running_class = running_class;
    }

    @Column(name="groupsub", nullable=false)
    public String getGroupsub() {
        return groupsub;
    }

    public void setGroupsub(String groupsub) {
        this.groupsub = groupsub;
    }

    @Column(name="batch", nullable=false)
    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
    
    
    
    
}
