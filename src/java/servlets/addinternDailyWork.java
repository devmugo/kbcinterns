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
import models.internDailyWork;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class addinternDailyWork extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();
    String  success ;
     String error ;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            HttpSession sessionsa = request.getSession(false);
            int internid = (Integer) sessionsa.getAttribute("id");                
                       
            String date = request.getParameter("date");
            String workdone = request.getParameter("workdone");
            String skills = request.getParameter("skills");

            internDailyWork idw = new internDailyWork(internid, date, skills, workdone);
            session.save(idw);
            transaction.commit();            
            success = "Tasks added successfully";
        

        } catch (Exception e) {
            System.out.println("error in add intern work  " + e.getMessage());
            error = "Task could not be added. Try again later";

        } finally {
            request.setAttribute("success", success);
            request.setAttribute("error", error);
            
            RequestDispatcher rd = request.getRequestDispatcher("internDailyWork.jsp");
            rd.forward(request, response);
            

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
