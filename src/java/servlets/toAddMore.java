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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.colleges;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class toAddMore extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        try{
        int id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        
        String fullname = fname +" "+lname;

        ArrayList<String> myClgs = new ArrayList<String>();

        Criteria criteria = session.createCriteria(colleges.class);
        List<colleges> clgs;
        clgs = criteria.list();
        int clgsize = clgs.size();
        String[] clgsarray = new String[clgsize];

        for (colleges u : clgs) {

            String clg = u.getCollege_name();
            myClgs.add(clg);

        }
        clgsarray = myClgs.toArray(clgsarray);
        conv e = new conv();
        String clgy = e.getArrayString(clgsarray);
        
        
        
        request.setAttribute("clgy", clgy);
        request.setAttribute("name", fullname);
        request.setAttribute("id", id);
        
        
        System.out.println("id is " +id );
        
        }
        catch(Exception e){
        
        }
        finally{
            
            RequestDispatcher rd = request.getRequestDispatcher("addMoreDetails.jsp");
            rd.forward(request, response);
        
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
