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
import models.Users;
import models.internDailyWork;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author AMO
 */
public class checkInternsWork extends HttpServlet {
    public static SessionFactory factory = GetFactory.getFactory();
    String name;
 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        
         int id = Integer.parseInt(request.getParameter("id"));        
        
        try{       
        Criteria criteria = session.createCriteria(internDailyWork.class);
        criteria.add(Restrictions.eq("internid", id));
        criteria.addOrder(Order.desc("date"));
        List<internDailyWork> works;
        works = criteria.list();
        
       for(internDailyWork u:works){
         Users user = (Users) session.get(Users.class, id);
         String fname = user.getFirstname();
         String lname = user.getLastName();
         
         name = fname + " " + lname;         
         u.setName(name);   
       
       }
       
       request.setAttribute("name", name);
       request.setAttribute("work",works);
       
        RequestDispatcher rd = request.getRequestDispatcher("adminViewIndInternWork.jsp");
         rd.forward(request, response);
      
        
        
        }
        
        catch(Exception e){
            System.out.println("Error is "+ e.getMessage());
        
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
