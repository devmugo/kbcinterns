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
import models.Users;
import models.colleges;
import models.interns;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author AMO
 */
public class addInternDetails extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();
    int cole_id;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            
            int id = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("email");
            String uni = request.getParameter("cole");
            String course = request.getParameter("course");
            String phone = request.getParameter("phone");
            String from = request.getParameter("from");
            String to = request.getParameter("to");           
         

            Criteria criteria = session.createCriteria(colleges.class);
            criteria.add(Restrictions.eq("college_name", uni));
            List<colleges> coles;
            coles = criteria.list();
            for (colleges u : coles) {
                cole_id = u.getCollege_id();
            }
           
             HttpSession sessionsa = request.getSession(false);
            int userid = (Integer) sessionsa.getAttribute("id");
                      
            Boolean on_session = true;            
            try{
            interns intern = new interns(id, email,phone, cole_id, course, from, to,userid, on_session);
            session.save(intern);
           
           
            
            Users user = (Users) session.get(Users.class, id);
            user.setComp_details("yes");
            session.save(user);
            
            transaction.commit();
            response.sendRedirect("getInternFullDetails");
          
            }
            
            catch(Exception e){
                
                
                System.out.println("Error!!!!! " +e.getMessage());
            
            
            }
            
            

        } catch (Exception e) {
            
            
            System.out.println("error  " + e.getMessage());
        } finally {

            

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
