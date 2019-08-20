/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.Encrypt;
import factory.GetFactory;
import models.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.rols;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author AMO
 */
public class logIn extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();
    String success;
    String error;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session session = factory.openSession();
        session.beginTransaction();
        HttpSession sessionScope = request.getSession();
        try {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            try {
                String hql = "FROM Users U WHERE U.username = :username";
                Query query = session.createQuery(hql);
                query.setParameter("username", username);
                List<Users> results = query.list();

                System.out.println("user list is  " + results.size());
                if (results.size() == 0) {
                    sessionScope.setAttribute("loggedIn", false);
                    error = "User Does Not Exist. Contact The Admin";
                    request.setAttribute("error", error);
                    RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
                    rd.forward(request, response);

                }

                for (Users u : results) {

                    String passencrypted = u.getPwencrypt();
                    int userid = u.getId();
                    Encrypt enc = new Encrypt();
                    //decrypting the password 
                    String pass = enc.decrypt(passencrypted);

                    int role = u.getRoleid();
                    String active = u.getActive();

                    if (active.equalsIgnoreCase("off")) {
                        sessionScope.setAttribute("loggedIn", false);
                        error = "You are currently not allowed to use the system. Contact The Admin";
                        request.setAttribute("error", error);
                        RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
                        rd.forward(request, response);

                    }

                    hql = "FROM rols R WHERE R.role_id = :role";
                    query = session.createQuery(hql);
                    query.setParameter("role", role);
                    List<rols> roles = query.list();

                    for (rols r : roles) {
                        String kazi = r.getRole_name();

                        if (kazi.equalsIgnoreCase("admin") && pass.equals(password)) {
                            sessionScope.setAttribute("loggedIn", true);
                            sessionScope.setAttribute("user", u.getFirstname());
                            sessionScope.setAttribute("id", u.getId());
                            sessionScope.setAttribute("role", "admin");
                            request.setAttribute("success", success);
                            response.sendRedirect("addUser");

                        }//normal user log in
                        else if (kazi.equalsIgnoreCase("intern") == true && pass.equals(password) == true) {
                            sessionScope.setAttribute("loggedIn", true);
                            sessionScope.setAttribute("user", u.getFirstname());
                            sessionScope.setAttribute("role", "intern");
                            sessionScope.setAttribute("id", u.getId());

                            RequestDispatcher rd = request.getRequestDispatcher("internDailyWork.jsp");
                            rd.forward(request, response);

                        } else if (kazi.equalsIgnoreCase("hr") && pass.equals(password)) {
                            sessionScope.setAttribute("loggedIn", true);
                            sessionScope.setAttribute("user", u.getFirstname());
                            sessionScope.setAttribute("id", u.getId());
                            sessionScope.setAttribute("role", "hr");
                            response.sendRedirect("toAddIntern");

                        } else if (kazi.equalsIgnoreCase("supervisor") && pass.equals(password)) {
                            sessionScope.setAttribute("loggedIn", true);
                            sessionScope.setAttribute("user", u.getFirstname());
                            sessionScope.setAttribute("id", u.getId());
                            sessionScope.setAttribute("dprtid", u.getDepartmentid());
                            sessionScope.setAttribute("role", "supervisor");
                            response.sendRedirect("fillAttendance");

                        } else {
                            sessionScope.setAttribute("loggedIn", false);
                            error = "Wrong user name or password ";
                            request.setAttribute("error", error);
                            RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
                            rd.forward(request, response);

                        }

                    }
                }
            } catch (Exception e) {

            }

        } catch (Exception e) {
            System.out.println("Error = " + e.getMessage());
            sessionScope.setAttribute("loggedIn", false);
            error = "User Does Not Exist. Contact The Admin";
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
            rd.forward(request, response);

        }

    }

}
