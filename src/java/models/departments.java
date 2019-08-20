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

/**
 *
 * @author AMO
 */
@Entity
public class departments implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int dept_id;
    @Column(name = "dept_name", nullable = false, unique = true)
     private String dept_name; 
    @Column(name = "created_by", nullable = false)
    private int created_by; 
      
       public departments() {
    }
    

    public departments(String dept_name, int created_by) {
       
        this.dept_name = dept_name;
        this.created_by = created_by;
    }

    public int getDept_id() {
        return dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

   
    
    
      
      
      
      
    
}



