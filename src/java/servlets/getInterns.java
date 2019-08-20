/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.GetFactory;
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
import models.interns;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author AMO
 */
public class getInterns extends HttpServlet {
     public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        try {
            HttpSession sessionsa = request.getSession(false);
            String department = (String) sessionsa.getAttribute("dprt");  
           
            Criteria criteria = session.createCriteria(interns.class);
            criteria.add(Restrictions.eq("department",department ));            
           List<interns>  interns = criteria.list();  
            
            
            request.setAttribute("interns", interns);

           
        } catch (Exception e) {
            System.out.println("error is " +e.getMessage());
            
        } finally {
            
             RequestDispatcher rd = request.getRequestDispatcher("supervisorHome.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
