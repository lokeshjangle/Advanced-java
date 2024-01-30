package example.hibernate.programmatic.utils;

import example.hibernate.programmatic.entity.Restaurant;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtils {
    //This class is used to build SessionFactory and return the same.
    //Eg. HibernateUtils.getSessionFactory()
    public static SessionFactory getSessionFactory(){
        Configuration config = new Configuration();
        Class<Restaurant> entityClass = Restaurant.class;  //This class handles all the mapping for Table and columns
        config.addAnnotatedClass(entityClass);//Registers this entity class with Configuration

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
