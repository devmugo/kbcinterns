/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author AMO
 */
@Entity
public class Users implements Serializable {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO,generator="native")    
    @GenericGenerator( name="native",strategy="native")
    private int id;
    
      
     @Column(name = "firstname", nullable = false)
    private String firstname;
    
   @Column(name = "lastname", nullable = false)
    private String lastName;
   
    @Column(name = "therole", nullable = false)
    private int roleid;
    
    @Column(name = "username", unique=true, nullable = false)
    private String username;
   
    @Column(name = "password",  nullable = false)
    private String pwencrypt;
    
     @Column(name = "dprtid",  nullable = false)
    private int departmentid;

   @Column(name = "stationid",  nullable = false)
    private int stnid;
   
    @Column(name = "editor",  nullable = true)
    private int editor;
    @Transient
    private String dprt_name;
    @Transient
    private String role_name;
    @Transient
    private String stn_name;
    
    private String active;
    
    @Column(name = "comp_details",  nullable = true)
    private String comp_details;
    
    public Users() {
    }

    public Users( String firstname, String lastName, int roleid, String username, String pwencrypt, int departmentid, int stnid,  int editor,String active) {
        this.editor = editor;
        this.firstname = firstname;
        this.lastName = lastName;
        this.roleid = roleid;
        this.username = username;
        this.pwencrypt = pwencrypt;
        this.departmentid = departmentid;
        this.stnid = stnid;
        this.active = active;
        
    }

   

    public int getId() {
        return id;
    }

    public String getDprt_name() {
        return dprt_name;
    }

    public void setDprt_name(String dprt_name) {
        this.dprt_name = dprt_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getStn_name() {
        return stn_name;
    }

    public void setStn_name(String stn_name) {
        this.stn_name = stn_name;
    }

   

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwencrypt() {
        return pwencrypt;
    }

    public void setPwencrypt(String pwencrypt) {
        this.pwencrypt = pwencrypt;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public int getStnid() {
        return stnid;
    }

    public void setStnid(int stnid) {
        this.stnid = stnid;
    }

    public int getEditor() {
        return editor;
    }

    public void setEditor(int editor) {
        this.editor = editor;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getComp_details() {
        return comp_details;
    }

    public void setComp_details(String comp_details) {
        this.comp_details = comp_details;
    }
    
    
    

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + ", roleid=" + roleid + ", email=" + username + ", pwencrypt=" + pwencrypt + ", departmentid=" + departmentid + ", stnid=" + stnid + ", editor=" + editor + '}';
    }
    
    

  

  
   
    
    
}
