/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import org.hibernate.SessionFactory;

/**
 *
 *
 */
public class GetFactory {
    public static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        GetFactory.factory = factory;
    }
    
}
