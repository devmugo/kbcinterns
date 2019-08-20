
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
import javax.servlet.http.HttpSession;
import models.Users;
import models.internDailyWork;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author AMO
 */
public class internViewOwnWork extends HttpServlet {
    public static SessionFactory factory = GetFactory.getFactory();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = factory.openSession();
        
        try{
           HttpSession sessionsa = request.getSession(false);
            int userid = (Integer) sessionsa.getAttribute("id");
            
          Criteria  criteria = session.createCriteria(internDailyWork.class);
           criteria.add(Restrictions.eq("internid", userid));
           criteria.addOrder(Order.desc("date"));
           List<internDailyWork> work= new ArrayList<internDailyWork>();
           work = criteria.list(); 
           request.setAttribute("work", work);
           
           RequestDispatcher rd = request.getRequestDispatcher("internViewOwnActs.jsp");
            rd.forward(request, response);    
            
           
        
        }
        catch(Exception e){
        
        }
        
        
       
    }

     
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
