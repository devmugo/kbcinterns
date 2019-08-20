/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.GetFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import models.attendance;
import models.rols;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import static servlets.fillAttendance.factory;

/**
 *
 * @author AMO
 */
public class viewAttendance extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        List<Users> usr = new ArrayList<Users>();
        int role_id= 1;

        String date = request.getParameter("date");
        if (date == null) {
            Date ndate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(ndate);
        }
        HttpSession sessionsa = request.getSession(false);
        int dprtid = (Integer) sessionsa.getAttribute("dprtid");        

        try {
            Criteria criteria = session.createCriteria(attendance.class);            
            criteria.add(Restrictions.eq("date", date));
            criteria.add(Restrictions.eq("dprt_id", dprtid));
            List<attendance> presentees = new ArrayList<attendance>();
            presentees= criteria.list();
            
          for(attendance a:presentees){           
           usr = a.getPresent();          
          
          }
          
           criteria = session.createCriteria(rols.class);
            List<rols> dpts;
            criteria.add(Restrictions.eq("role_name", "INTERN"));
            dpts = criteria.list();          

            for (rols u : dpts) {
                role_id = u.getRole_id();
            }
         criteria = session.createCriteria(Users.class);
         criteria.add(Restrictions.eq("departmentid", dprtid)).add(Restrictions.eq("roleid", role_id));
         List<Users> users;
         users = criteria.list();          
          users.removeAll(usr);            
          request.setAttribute("present", usr);
          request.setAttribute("absent",users); 
          request.setAttribute("date",date);
          
           RequestDispatcher rd = request.getRequestDispatcher("viewAttendance.jsp");
            rd.forward(request, response);
            

        } catch (Exception e) {
            System.out.println("error " +e.getMessage());

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
