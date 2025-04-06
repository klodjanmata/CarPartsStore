package Util;

import Entity.Part;
import Entity.SaleTransaction;
import Entity.Supplier;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try{
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Part.class)
                    .addAnnotatedClass(SaleTransaction.class)
                    .addAnnotatedClass(Supplier.class)
                    .buildSessionFactory();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }

}

