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
public class rols implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int role_id;
    @Column(name = "role_name", nullable = false, unique = true)
    private String role_name;
    @Column(name = "created_by", nullable = false)
    private int created_by;

    public rols() {
    }

    public rols(String role_name, int created_by) {
     
        this.role_name = role_name;
        this.created_by = created_by;
    }

    public int getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "roles{" + "role_id=" + role_id + ", role_name=" + role_name + ", created_by=" + created_by + '}';
    }
    
    

}
