/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import factory.GetFactory;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import models.departments;
import models.stations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author AMO
 */
public class supervisorProfile extends HttpServlet {
     public static SessionFactory factory = GetFactory.getFactory();

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      try{
        Session session = factory.openSession();

        HttpSession sessionsa = request.getSession(false);
        int userid = (Integer) sessionsa.getAttribute("id");

        Users user =  (Users) (session.get(Users.class, userid));
        String username = user.getUsername();        
        String fname = user.getFirstname();
        String lname = user.getLastName();         
        String name = fname + " "+ lname;
        
        int station = user.getStnid();        
        stations stn = (stations) (session.get(stations.class,station));
        String stnname = stn.getStation();
        
        int dprtid = user.getDepartmentid();        
        departments dprt = (departments) (session.get(departments.class,station));
        String dprtname = dprt.getDept_name();
        
        request.setAttribute("name",name);
        request.setAttribute("station",stnname);
        request.setAttribute("dprt",dprtname);
        request.setAttribute("username",username);
        request.setAttribute("id",userid);
        
        RequestDispatcher rd = request.getRequestDispatcher("supervisorProfile.jsp");
        rd.forward(request, response);
        
        }
       catch(Exception e){
       System.out.println("Error in Adminprofile is  " + e.getMessage());
       }
        
       
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
