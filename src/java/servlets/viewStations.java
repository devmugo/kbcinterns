/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.GetFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.stations;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author AMO
 */
public class viewStations extends HttpServlet {

   public static SessionFactory factory = GetFactory.getFactory();

 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try{
            
            Criteria criteria = session.createCriteria(stations.class);
            List<stations> stns;
            stns = criteria.list();
            session.close();
            request.setAttribute("stns", stns);
            
          
        
        } 
        
        catch(Exception e){
        
        
        }
        
        finally{
         RequestDispatcher rd = request.getRequestDispatcher("viewStations.jsp");
         rd.forward(request, response);
        }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
