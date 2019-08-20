/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.GetFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.departments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AMO
 */
public class addDprt extends HttpServlet {

  
  public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            HttpSession sessionsa = request.getSession(false);
            int userid = (Integer) sessionsa.getAttribute("id");

            String dpt = request.getParameter("dprt").toUpperCase();            
            departments dprt = new departments(dpt, userid);
            session.save(dprt);
            transaction.commit();
            
            response.sendRedirect("addUser");
            
        } catch (Exception e) {
           System.out.println("Error = " +e.getMessage()); 
             RequestDispatcher rd = request.getRequestDispatcher("addUser.jsp");
            rd.forward(request, response);

        }
        
        finally{
       
        
        }
        }
        catch(Exception e){
        System.out.println("error " +e.getMessage());
        }

   


}
}
