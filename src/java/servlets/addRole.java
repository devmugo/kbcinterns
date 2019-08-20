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

import models.rols;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AMO
 */
public class addRole extends HttpServlet {

  
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

            String role = request.getParameter("role").toUpperCase();             
            rols rol = new rols(role, userid);
            session.save(rol);
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
