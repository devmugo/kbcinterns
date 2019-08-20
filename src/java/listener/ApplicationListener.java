/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import bean.Encrypt;
import factory.GetFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import models.Users;
import models.attendance;
import models.colleges;
import models.departments;
import models.internDailyWork;
import models.interns;
import models.rols;
import models.stations;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



/**
 * Web application lifecycle listener.
 *
 * @author amo
 */
@WebListener()
public class ApplicationListener implements ServletContextListener {

    private SessionFactory factory;
    private ServiceRegistry registry;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Configuration configuration = new Configuration().configure();
             configuration.addAnnotatedClass(Users.class);
             configuration.addAnnotatedClass(interns.class);
             configuration.addAnnotatedClass(internDailyWork.class);                     
             configuration.addAnnotatedClass(stations.class);
             configuration.addAnnotatedClass(rols.class);
             configuration.addAnnotatedClass(departments.class);
             configuration.addAnnotatedClass(colleges.class);
             configuration.addAnnotatedClass(attendance.class);
           
           
            
            registry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(registry);
            sce.getServletContext().setAttribute("factory", factory);
            sce.getServletContext().setAttribute("registry", registry);

            GetFactory.setFactory(factory);

            Session session = factory.openSession();
            Transaction tx = null;
            
            
        
            
            try {
                
              Encrypt enc = new Encrypt();
             String pass =  enc.encrypt("12345678");
             Users admin = new Users("Amos", "Mwangi",1,"admin",pass,1,1,1,"on" );
              rols rol = new rols("ADMIN",1);
            
               tx = session.beginTransaction();
               session.saveOrUpdate(admin);
               session.saveOrUpdate(rol);
               tx.commit();                
              
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                System.err.println("Hibernate error occurred: " + e);
            } catch (Exception ex) {
                Logger.getLogger(ApplicationListener.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            System.err.println("Failed to create sessionFactory object: " + e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        factory = (SessionFactory) sce.getServletContext().getAttribute("factory");
        registry = (ServiceRegistry) sce.getServletContext().getAttribute("registry");
        try {
            if ((factory != null) && (registry != null)) {
                factory.close();
                StandardServiceRegistryBuilder.destroy(registry);
            }
        } catch (HibernateException e) {
            System.err.println("Failed to close factory: " + e);
        }
    }
}
