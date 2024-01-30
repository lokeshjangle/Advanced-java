package example.hibernate.main;

import example.hibernate.entity.Restaurant;
import example.hibernate.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;


public class Program {
    private static void createNewRestaurant() {

        Configuration config = new Configuration();
        config = config.configure();

        //Obtaining Session Factory
        SessionFactory factory = config.buildSessionFactory();
        //Obtain Session
        Session session = factory.openSession();
        //Building an entity class object
        Restaurant rst = new Restaurant(102, "Hotel Silver Star", "Chinese", 10); //Transient state
        //Obtaining and Starting the Transaction
        Transaction tx = session.beginTransaction();
        session.persist(rst); //Storing the Restaurant object as a record  //Persistance state
        tx.commit();
        session.close(); //Detached State
        factory.close();
    }

    private static void showOneRestaurant() {

        try(SessionFactory factory =  HibernateUtils.getSessionFactory();
            Session session = factory.openSession();
            ){
            //Since this is data retrieval, there is no need of Transaction because transaction is used only for dml commmand
            Class<Restaurant> restaurnatType = Restaurant.class;
            Serializable id = 101; //Serializable id = new Integer(101);
            //This is because Hibernate enforce one rule
            //The type of the 'id' fiels must be implementing java.io.Serializable
            Restaurant foundRestaurant = session.find(restaurnatType,id);
            System.out.println(foundRestaurant);
            System.out.println("Name: "+foundRestaurant.getName());
            System.out.println("Cuisine: "+foundRestaurant.getCuisine());
            System.out.println("Number of branches: "+foundRestaurant.getBranchCount());

        }
    }
    private static void updateRestaurant() {

        try(
            SessionFactory factory = HibernateUtils.getSessionFactory();
            Session session = factory.openSession();) {


            Class<Restaurant> restaurantType = Restaurant.class;
            Serializable id = 102;

            Restaurant foundRestaurant = session.find(restaurantType,id);
            Transaction tx = session.beginTransaction();
            //Update Hotel Name
            foundRestaurant.setName("Silver Sand");

            //Update Hotel Cuisine
            foundRestaurant.setCuisine("Italian");
            tx.commit();


        }
        System.out.println("Record Updated...");

    }
    private static void deleteRestaurant() {
        try( SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();)
        {
            Class<Restaurant> restaurantType = Restaurant.class;
            Serializable id = 102;
            Restaurant foundRestaurant = session.find(restaurantType,id);
            Transaction tx = session.beginTransaction();
                session.remove(foundRestaurant);  //Removed State
            tx.commit();
        }
        System.out.println("Record Deleted Succefully...");
    }

    public static void main(String[] args){
       // createNewRestaurant();
        showOneRestaurant();
        //updateRestaurant();
        deleteRestaurant();

    }
}
