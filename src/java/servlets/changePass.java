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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import models.rols;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AMO
 */
public class changePass extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            
        Session session = factory.openSession();
         Transaction transaction = session.beginTransaction();
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("passn");
        String pass1 = request.getParameter("pass1");  
        
        Encrypt enc = new Encrypt();
        String pass =  enc.encrypt(password);        
        String pass2 = enc.encrypt(pass1);       

        Users user = (Users) session.get(Users.class, id);
        int roleid= user.getRoleid();
        
        rols role = (rols) session.get(rols.class,roleid);  
        String rolename = role.getRole_name();       
        String encpass = user.getPwencrypt();  
        
        if(pass2.equals(encpass)){            
        user.setPwencrypt(pass);        
        transaction.commit();
        session.save(user);
        String success = "Password reset was successful.Use the new password to Log in";
        HttpSession sn = request.getSession();
        sn.invalidate();        
        request.setAttribute("success", success);        
        RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
        rd.forward(request, response);
        }
        
        else if(rolename.equalsIgnoreCase("admin")&& pass2 != (encpass)){            
             response.sendRedirect("adminProfile"); 
     
        }
        
        
        else if(rolename.equalsIgnoreCase("supervisor")&& pass2 != (encpass)){
        response.sendRedirect("supervisorProfile");
        
        }
         else if(rolename.equalsIgnoreCase("hr")&& pass2 != (encpass)){
        response.sendRedirect("hrProfile");
        
        }
         else{
        response.sendRedirect("supervisorProfile");
        
        }
        
        }
        
        catch(Exception e){
        
        }
    }

}
