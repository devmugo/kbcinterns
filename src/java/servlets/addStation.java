package servlets;

import factory.GetFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.stations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import static servlets.addinternDailyWork.factory;

/**
 *
 * @author AMO
 */
public class addStation extends HttpServlet {

    public static SessionFactory factory = GetFactory.getFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
           HttpSession sessionsa = request.getSession(false);
            int userid = (Integer) sessionsa.getAttribute("id");
            String station = request.getParameter("station").toUpperCase();             
            stations stn = new stations(station, userid);
            session.save(stn);
            transaction.commit();
            
            response.sendRedirect("addUser");
            
        } catch (Exception e) {
           System.out.println("Error = " +e.getMessage()); 
             RequestDispatcher rd = request.getRequestDispatcher("addUser.jsp");
            rd.forward(request, response);

        }
        
        finally{
       
        
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
