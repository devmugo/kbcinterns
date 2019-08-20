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
import javax.servlet.http.HttpSession;
import models.Users;
import models.departments;
import models.rols;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import static servlets.logIn.factory;

/**
 *
 * @author AMO
 */
public class fillAttendance extends HttpServlet {

    int role_id;
    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        session.beginTransaction();

        HttpSession sessionsa = request.getSession(false);
        int dprt_id = (Integer) sessionsa.getAttribute("dprtid");       
        
        try {
            Criteria criteria = session.createCriteria(rols.class);
            List<rols> dpts;
            criteria.add(Restrictions.eq("role_name", "INTERN"));
            dpts = criteria.list();          

            for (rols u : dpts) {
                role_id = u.getRole_id();
            }
            
            criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq("departmentid", dprt_id)).add(Restrictions.eq("roleid", role_id)).add(Restrictions.eq("active", "on"));
            List<Users> users;
            users = criteria.list();                   
                      
            request.setAttribute("interns",users);            
           
             RequestDispatcher rd = request.getRequestDispatcher("registerAttendance.jsp");
            rd.forward(request, response);
            
        } catch (Exception e) {
            System.out.println("The error is  "+ e.getMessage());

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
