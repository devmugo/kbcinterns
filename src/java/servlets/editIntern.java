/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.GetFactory;
import static factory.GetFactory.factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author AMO
 */
//fetches all interns from the user table to display in the edit jsp table 
public class editIntern extends HttpServlet {
 public static SessionFactory factory = GetFactory.getFactory();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
         Session session = factory.openSession();
         try{
         
           
         Criteria criteria = session.createCriteria(Users.class);
         criteria.add(Restrictions.eq("role", "intern"));
         List<Users> interns ;
         interns= criteria.list();  
         session.close();
          request.setAttribute("interns", interns);
         
         }
         catch(Exception e){
           
         }
         finally{
             
              RequestDispatcher rd = request.getRequestDispatcher("editInterns.jsp");
            rd.forward(request, response);
         }
          
           
        
    } 
       
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
