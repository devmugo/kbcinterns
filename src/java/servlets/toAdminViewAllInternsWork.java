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
import models.rols;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author AMO
 */
public class toAdminViewAllInternsWork extends HttpServlet {
     public static SessionFactory factory = GetFactory.getFactory();
     int role_id=1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        
         HttpSession sessionsa = request.getSession(false);
        int dprtid = (Integer) sessionsa.getAttribute("dprtid"); 
        
       Criteria criteria = session.createCriteria(rols.class);
            List<rols> role;
            criteria.add(Restrictions.eq("role_name", "INTERN"));
            role = criteria.list();          

            for (rols u : role) {
                role_id = u.getRole_id();
            }
        
        
        criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("departmentid", dprtid)).add(Restrictions.eq("roleid", role_id));
        List<Users> users;
        users = criteria.list();

        request.setAttribute("interns", users);

        RequestDispatcher rd = request.getRequestDispatcher("checkInternsActitvities.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
