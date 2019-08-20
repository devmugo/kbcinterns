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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author AMO
 */
public class restoreUser extends HttpServlet {

  public static SessionFactory factory = GetFactory.getFactory();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try{
        
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("pass");
        
        HttpSession sessionsa = request.getSession(false);
        int adminid = (Integer) sessionsa.getAttribute("id");
        
        Users user = (Users) session.get(Users.class,adminid);
        String dbpass = user.getPwencrypt();
        
         Encrypt enc = new Encrypt();
        String inpass =  enc.encrypt(password);
        
        if(dbpass.equalsIgnoreCase(inpass)){
           user = (Users) session.get(Users.class,id);
           user.setActive("on");
           session.save(user);
           transaction.commit(); 
           
           response.sendRedirect("viewUsers");
           
            
        }
        else{
            
            response.sendRedirect("disabledUsers");
        
        }
        
        
        
        }
        
        catch(Exception e){
        
        }
        
       
        
    }


}
