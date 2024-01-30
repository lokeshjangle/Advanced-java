package example.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    //This class is used to build SessionFactory and return the same.
    //Eg. HibernateUtils.getSessionFactory()
    public static SessionFactory getSessionFactory(){
        Configuration config = new Configuration();
        config = config.configure();
        SessionFactory factory = config.buildSessionFactory();
        return  factory;
    }
}
