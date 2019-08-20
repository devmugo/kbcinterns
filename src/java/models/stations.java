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
public class stations implements Serializable {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO,generator="native")    
   @GenericGenerator( name="native",strategy="native")    
    private int station_id; 
    
   @Column(name = "station", nullable = false,unique=true)
    private String station;
   
    @Column(name = "added_by", nullable = false)
    private int added_by;
    
     private String adder;
    
    

    public stations() {
    }

    public stations(String station, int added_by) {
        this.station = station;
        this.added_by = added_by;
    }

    public int getAdded_by() {
        return added_by;
    }

    public void setAdded_by(int added_by) {
        this.added_by = added_by;
    }

    public String getAdder() {
        return adder;
    }

    public void setAdder(String adder) {
        this.adder = adder;
    }
    
    public int getStation_id() {
        return station_id;
    }

   

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "stations{" + "station_id=" + station_id + ", station=" + station + '}';
    }
    
    
    
    
   
   
 
    
}
