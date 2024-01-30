package example.hibernate.programmatic.main;

import example.hibernate.programmatic.entity.Restaurant;
import example.hibernate.programmatic.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateAnnotationExampleMain {
    public static void main(String[] args){
        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session = factory.openSession();
                ){
            Restaurant rest = new Restaurant(203,"Hotel Shalimar","Chinese",2);
            Transaction tx = session.beginTransaction();
            session.persist(rest);
            tx.commit();


        }
        System.out.println("Inserted successfully");
    }
}
