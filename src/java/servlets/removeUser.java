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
import models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import static servlets.addIntern.factory;

public class removeUser extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try{
        int id = Integer.parseInt(request.getParameter("id"));

        if (id == 1) {
            String error = "Unable to complete the process. Please contact the admin for more details";
            response.sendRedirect("viewUsers");

        } else {
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Users user = (Users) session.get(Users.class, id);           
            user.setActive("off");
            session.save(user);
            transaction.commit();            
            response.sendRedirect("viewUsers");
            
            
            

        }
        }
        
        catch(Exception e ){
              response.sendRedirect("viewUsers");
              
        
        }
    }

}
