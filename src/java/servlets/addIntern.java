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
import models.stations;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author AMO
 */
public class addIntern extends HttpServlet {

   
  
 public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String fname = request.getParameter("fname").toUpperCase();
            String lname = request.getParameter("lname").toUpperCase();
            String station = request.getParameter("station");
            String dprt = request.getParameter("department");
            String role = request.getParameter("role").toUpperCase();

            int role_id = 0;
            int dprt_id = 0;
            int stn_id = 0;

            Criteria criteria = session.createCriteria(rols.class);
            criteria.add(Restrictions.eq("role_name", role));
            List<rols> rle;
            rle = criteria.list();
            for (rols u : rle) {
                role_id = u.getRole_id();
            }

            String username = (fname + lname).toLowerCase();

            Encrypt enc = new Encrypt();
            String password = enc.encrypt(username);

            criteria = session.createCriteria(departments.class);
            criteria.add(Restrictions.eq("dept_name", dprt));
            List<departments> dpt;
            dpt = criteria.list();
            for (departments u : dpt) {
                dprt_id = u.getDept_id();
            }

            criteria = session.createCriteria(stations.class);
            criteria.add(Restrictions.eq("station", station));
            List<stations> stn;
            stn = criteria.list();
            for (stations u : stn) {
                stn_id = u.getStation_id();
            }
            HttpSession sessionsa = request.getSession(false);
            int userid = (Integer) sessionsa.getAttribute("id");

           String active = "on";

            Users user = new Users(fname, lname, role_id, username, password, dprt_id, stn_id,userid,active);
            if ("INTERN".equals(role)){
                user.setComp_details("no");
            
            }
            session.save(user);
            transaction.commit();
            session.close();

            response.sendRedirect("viewUneditedInterns");

        } catch (Exception e) {

            RequestDispatcher rd = request.getRequestDispatcher("  ");
            rd.forward(request, response);

        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
