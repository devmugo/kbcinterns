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
import javax.servlet.http.HttpSession;
import models.internDailyWork;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import static servlets.addInternDetails.factory;


public class checkDailyWorkIntern extends HttpServlet {
     public static SessionFactory factory = GetFactory.getFactory();

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
             
          
        
        try{
            
            HttpSession sessionsa = request.getSession(false);
            int id = (Integer) sessionsa.getAttribute("id");
            String date = request.getParameter("date");   
            System.out.println("date is " + date);
             String hql = "FROM internDailyWork idw WHERE idw.date = :date and idw.internid =:id";
            Query query = session.createQuery(hql);
            query.setParameter("date", date);
            query.setParameter("id", id);
            List<internDailyWork> results = query.list(); 
            
            System.out.println("list  " + results );
            request.setAttribute("work",results);
            request.setAttribute("date",date);
            
            
        } catch(Exception e){
            System.out.println("error " + e.getMessage());
            
           
        }
        finally{
        RequestDispatcher rd = request.getRequestDispatcher("internViewOwnActs.jsp");
        rd.forward(request, response);
        }
        
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
