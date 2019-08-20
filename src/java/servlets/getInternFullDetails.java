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
import models.Users;
import models.colleges;
import models.interns;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AMO
 */
public class getInternFullDetails extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();
    String college= "";
    String full_name = "";
    String first_name = " ";
    String last_name = " ";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();        

        try {

            Criteria criteria = session.createCriteria(interns.class);
            List<interns> ints;
            ints= criteria.list();
            
            for(interns u :ints){
                
               int user_id = u.getUserid();                
               Users user = (Users) session.get(Users.class, user_id);
               first_name   = user.getFirstname();
               last_name = user.getLastName();
               full_name = first_name + " "+ last_name ;
               
               int cole_id = u.getCollege_id();
               colleges cole = (colleges) session.get(colleges.class,cole_id);
               college =  cole.getCollege_name();
               
               u.setCollege_name(college);
               u.setFullname(full_name);
               
            }
            session.close();
            
            request.setAttribute("interns", ints);

        } catch (Exception e) {

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("internsinfull.jsp");
            rd.forward(request, response);
        }

    }

}
