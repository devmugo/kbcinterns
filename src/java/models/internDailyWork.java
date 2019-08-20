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
public class internDailyWork implements Serializable {
    
   @Id    
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")    
    @GenericGenerator( name="native",strategy="native")    
    private int id;
   @Column(name = "internid", nullable = false)
    private int internid;
    
    @Column(name = "thedate", nullable = false)
    private String date;
    @Column(name = "skills", nullable = false)
    private String skillslearnt;
    @Column(name = "workdone", nullable = false)
    private String workdone;
    
    @Transient
    private String name;

    public internDailyWork() {
    }

    public internDailyWork(int internid, String date, String skillslearnt, String workdone) {
        this.internid = internid;
        this.date = date;
        this.skillslearnt = skillslearnt;
        this.workdone = workdone;
    }

    public int getId() {
        return id;
    }

   

    public int getInternid() {
        return internid;
    }

    public void setInternid(int internid) {
        this.internid = internid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSkillslearnt() {
        return skillslearnt;
    }

    public void setSkillslearnt(String skillslearnt) {
        this.skillslearnt = skillslearnt;
    }

    public String getWorkdone() {
        return workdone;
    }

    public void setWorkdone(String workdone) {
        this.workdone = workdone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "internDailyWork{" + "id=" + id + ", internid=" + internid + ", date=" + date + ", skillslearnt=" + skillslearnt + ", workdone=" + workdone + '}';
    }
    
    
    
    
    
    
}
