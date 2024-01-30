package relationship.hibernate.Many_to_many.Bidirectional.entity.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import relationship.hibernate.Many_to_many.Bidirectional.entity.Actor;
import relationship.hibernate.Many_to_many.Bidirectional.entity.Movie;

import java.util.Properties;

public class HibernateUtils {
    //This class is used to build SessionFactory and return the same.
    //Eg. HibernateUtils.getSessionFactory()
    public static SessionFactory getSessionFactory(){
        Configuration config = new Configuration();
        config.addAnnotatedClass(Movie.class);
        config.addAnnotatedClass(Actor.class);//Registers this entity class with Configuration

        Properties configPrps = new Properties();
        configPrps.put("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        configPrps.put("hibernate.connection.url","jdbc:mysql://localhost:3306/lokesh?useSSL=false");
        configPrps.put("hibernate.connection.username","root");
        configPrps.put("hibernate.connection.password","1208");
        configPrps.put("hibernate.show_sql","true");
        configPrps.put("hibernate.hbm2ddl.auto","update");

        config.setProperties(configPrps); //Linking properties available inside properties object with configuration object
        SessionFactory factory = config.buildSessionFactory();
        return  factory;


    }
}
