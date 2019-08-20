/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.Encrypt;
import factory.GetFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AMO
 */
public class resetPassAdmin extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

           
                Session session = factory.openSession();
                Transaction transaction = session.beginTransaction();
                
                 Encrypt enc = new Encrypt();
                String pass =  enc.encrypt("12345678");

                Users user = (Users) session.get(Users.class, id);
                user.setPwencrypt(pass);
               session.save(user);
               transaction.commit();
               response.sendRedirect("viewUsers");

            
        } catch (Exception e) {
            response.sendRedirect("viewUsers");

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
