/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.GetFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import models.interns;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import static servlets.checkDailyWorkIntern.factory;

/**
 *
 * @author AMO
 */
public class profile extends HttpServlet {
     public static SessionFactory factory = GetFactory.getFactory();

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
         
          HttpSession sessionsa = request.getSession(false);
          int id = (Integer) sessionsa.getAttribute("id");  
         Criteria criteria = session.createCriteria(interns.class);
         criteria.add(Restrictions.eq("userid", id));        
         
         List<interns> intern ;
         
         intern= criteria.list();  
         
         request.setAttribute("intern", intern);
        
         
         
         
         }
         catch(Exception e){
             System.out.println("error " + e.getMessage());
           
         }
         finally{
            RequestDispatcher rd = request.getRequestDispatcher("changeProfileIntern.jsp");
            rd.forward(request, response);
        
        }
      
    }

    
 

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
