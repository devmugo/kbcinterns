/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author AMO
 */
@Entity
public class interns implements Serializable {

    @Id
    @Column(name = "userid", nullable = false)
    private int userid;

    @Column(name = "email", nullable = false)
    private String email;
    
      @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "college_id", nullable = false)
    private int college_id;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "pfrom", nullable = false)
    private String from;

    @Column(name = "pto", nullable = false)
    private String to;

     @Column(name = "added_by", nullable = false)
    private int added_by;
     
    @Column(name = "on_session", nullable = false)
    private Boolean on_session;

    @Transient
    private String college_name;

    @Transient
    private String fname;

    @Transient
    private String lname;

    @Transient
    private String fullname;

    public interns() {
    }

    public interns(int userid, String email, String phone, int college_id, String course, String from, String to, int added_by, Boolean on_session) {
        this.userid = userid;
        this.email = email;
        this.phone = phone;
        this.college_id = college_id;
        this.course = course;
        this.from = from;
        this.to = to;
        this.added_by = added_by;
        this.on_session = on_session;
        this.college_name = college_name;
        this.fname = fname;
        this.lname = lname;
        this.fullname = fullname;
    }

  

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
   public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Boolean getOn_session() {
        return on_session;
    }

    public void setOn_session(Boolean on_session) {
        this.on_session = on_session;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    

    @Override
    public String toString() {
        return "interns{" + "userid=" + userid + ", email=" + email + ", college_id=" + college_id + ", course=" + course + ", from=" + from + ", to=" + to + ", on_session=" + on_session + '}';
    }

}
