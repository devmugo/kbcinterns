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
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.departments;
import models.rols;
import models.stations;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author AMO
 */
public class addUser extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            ArrayList<String> myRoles = new ArrayList<String>();
            ArrayList<String> myStns = new ArrayList<String>();
            ArrayList<String> myDpts = new ArrayList<String>();

            Criteria criteria = session.createCriteria(departments.class);
            List<departments> dpts;
            dpts = criteria.list();
            int dprtsize = dpts.size();
            String[] dprtarray = new String[dprtsize];

            for (departments u : dpts) {

                String dpt = u.getDept_name();
                myDpts.add(dpt);

            }
            dprtarray = myDpts.toArray(dprtarray);
           
            request.setAttribute("dprts", dprtarray);
            conv e =new conv();
            String dprty = e.getArrayString(dprtarray);
            request.setAttribute("dprt", dprty);

            criteria = session.createCriteria(stations.class);
            List<stations> stns;
            stns = criteria.list();
            int stnsize = stns.size();
            String[] arraystn = new String[stnsize];

            for (stations u : stns) {

                String dpt = u.getStation();
                myStns.add(dpt);
            }
            arraystn = myStns.toArray(arraystn);
            
            request.setAttribute("stns", arraystn);
              conv d =new conv();
            String stny = d.getArrayString(arraystn);
            request.setAttribute("stn", stny);
            

            criteria = session.createCriteria(rols.class);
            List<rols> roles;
            roles = criteria.list();
            int rolesize = roles.size();
            String[] rolearray = new String[rolesize];

            for (rols u : roles) {

                String rls = u.getRole_name();
                myRoles.add(rls);
            }          
            
            rolearray = myRoles.toArray(rolearray);
            String role = (Arrays.toString(rolearray));
           
             conv c =new conv();
            String rolesn = c.getArrayString(rolearray);
            request.setAttribute("role", rolesn);
            
        } catch (Exception e) {

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("addUser.jsp");
            rd.forward(request, response);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

class conv {

    static String getArrayString(String[] items) {
        String result = "[";
        for (int i = 0; i < items.length; i++) {
            result += "\"" + items[i] + "\"";
            if (i < items.length - 1) {
                result += ", ";
            }
        }
        result += "]";

        return result;
    }

}
