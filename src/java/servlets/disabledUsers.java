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
import models.Users;
import models.departments;
import models.rols;
import models.stations;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import static servlets.viewUneditedInterns.factory;

/**
 *
 * @author AMO
 */
public class disabledUsers extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = factory.openSession();
        try {
            Criteria criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq("active", "off"));
            List<Users> users;
            users = criteria.list();
            
            for (Users u : users) {
                int dprt = u.getDepartmentid();
                departments dprto = (departments) session.get(departments.class, dprt);
                String dprt_name = dprto.getDept_name();
                u.setDprt_name(dprt_name);
                
                int stn = u.getStnid();
                stations stns = (stations) session.get(stations.class,stn);
                String stno = stns.getStation();
                u.setStn_name(stno);
                
                
                int role = u.getRoleid();
                rols rolo = (rols) session.get(rols.class,role);
                String role_name = rolo.getRole_name();
                u.setRole_name(role_name);
                

            }

            request.setAttribute("removed", users);
            RequestDispatcher rd = request.getRequestDispatcher("removedUsers.jsp");
            rd.forward(request, response);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

}
