/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class attendance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "date_added", nullable = false)
    private String date;
    @Column(name = "added_by", nullable = false)
    private int added_by;
    
    @Column(name = "signature", nullable = false,unique=true)
    private String sign;   
    
    @Column(name = "dprt_id", nullable = false)
    private int dprt_id;     
 
    @OneToMany
    @ElementCollection
    private List<Users> present = new ArrayList<Users>();
    
    

    public attendance() {
    }

    public attendance(String date, int added_by, String sign, List<Users> present,int dprt_id) {
        this.date = date;
        this.added_by = added_by;
        this.sign = sign;
        this.present = present;
        this.dprt_id=dprt_id;
    }  
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAdded_by() {
        return added_by;
    }

    public void setAdded_by(int added_by) {
        this.added_by = added_by;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public List<Users> getPresent() {
        return present;
    }

    public void setPresent(List<Users> present) {
        this.present = present;
    }

    public int getDprt_id() {
        return dprt_id;
    }

    public void setDprt_id(int dprt_id) {
        this.dprt_id = dprt_id;
    }

    @Override
    public String toString() {
        return "attendance{" + "id=" + id + ", date=" + date + ", added_by=" + added_by + ", sign=" + sign + ", dprt_id=" + dprt_id + ", present=" + present + '}';
    }
    
    
    
    
    
    

   

}
