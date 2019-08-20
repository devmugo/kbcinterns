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
import org.hibernate.annotations.GenericGenerator;

@Entity
public class colleges implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int college_id;
    @Column(name = "college_name", nullable = false, unique = true)
    private String college_name;
    @Column(name = "created_by", nullable = false)
    private int created_by;

    public colleges() {
    }

    public colleges(String college_name, int created_by) {
       
        this.college_name = college_name;
        this.created_by = created_by;
    }

    public int getCollege_id() {
        return college_id;
    }

    
    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "colleges{" + "college_id=" + college_id + ", college_name=" + college_name + ", created_by=" + created_by + '}';
    }
    
    
    
}
