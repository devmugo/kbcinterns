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
import java.util.Arrays;
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
import models.interns;
import models.rols;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author AMO
 */
public class checkRegister extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Users> present = new ArrayList<Users>();
        int role_id = 0;
        
        HttpSession sessionsa = request.getSession(false);
            int userid = (Integer) sessionsa.getAttribute("id");            
            int dprtid = (Integer) sessionsa.getAttribute("dprtid"); 
        
        

        try {
           Criteria criteria = session.createCriteria(rols.class);
            List<rols> dpts;
            criteria.add(Restrictions.eq("role_name", "INTERN"));
            dpts = criteria.list();          

            for (rols u : dpts) {
                role_id = u.getRole_id();
            }
            
            criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq("departmentid", dprtid)).add(Restrictions.eq("roleid", role_id)).add(Restrictions.eq("active", "on"));
            List<Users> users;
            users = criteria.list();
            
            int length = users.size();
           
            
            for (Users u: users) {
                int id = u.getId();
                String fid = Integer.toString(id);                               
                String att = request.getParameter(fid);
                if (att.equalsIgnoreCase("present")){
                    Users user = (Users) session.get(Users.class, id);
                    present.add(user);
                }
                
            
            
            }                      
                     
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String datedone = formatter.format(date);
            
            String signature = (datedone + userid);

            attendance att = new attendance(datedone,userid,signature,present,dprtid);
            session.save(att);
            transaction.commit();
            response.sendRedirect("viewAttendance");
             

            
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            //String error = "Attendance already checked";
            //request.setAttribute("error",error);            
            //response.sendRedirect("fillAttendance");
            

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
