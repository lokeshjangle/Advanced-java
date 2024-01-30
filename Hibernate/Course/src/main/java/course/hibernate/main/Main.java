package course.hibernate.main;
import course.hibernate.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {

    private static void createNewCourse(){
        Configuration config = new Configuration();
        config.configure();
        //Obtain Session Factory
        SessionFactory factory = config.buildSessionFactory();
        //Obtaining session
        Session session = factory.openSession();
        //Building an entity project
        Course crs = new Course(101,"Java","MET",6,20000);
        //Obtaining transaction
        Transaction tx = session.beginTransaction();
        session.persist(crs);
        tx.commit();
        session.close();
        factory.close();

    }

    private static void updateCourseDetail(){
        Scanner sc = new Scanner(System.in);
        Configuration config = new Configuration();
        config.configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        System.out.println("Enter Course Id:");
        int cid = sc.nextInt();
        System.out.println("Enter Course Name:");
        String name = sc.next();
        System.out.println("Enter Course Provider:");
        String provider = sc.next();
        System.out.println("Enter Course Duration:");
        int dur = sc.nextInt();
        System.out.println("Enter Course fees:");
        int fees = sc.nextInt();
        Course crs = new Course(cid,name,provider,dur,fees);
        Transaction tx = session.beginTransaction();
        session.merge(crs);
        tx.commit();
        session.close();
        factory.close();

    }

    private static void deleteCourse(int cid){
        Configuration config = new Configuration();
        config.configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Course crs = session.find(Course.class,cid);
        if(crs!=null){
            session.delete(crs);
        }
        else{
            System.out.println("Entity not found");
        }
        tx.commit();
        session.close();
        factory.close();
    }
    private static void showCourseDetail(int cid){
        Configuration config = new Configuration();
        config.configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        Course crs = session.get(Course.class,cid);
        System.out.println(crs.toString());

        tx.commit();
        session.close();
        factory.close();
    }
   public static void main(String[] args){
//        createNewCourse();
        showCourseDetail(101);
//        updateCourseDetail();
        deleteCourse(102);
   }

}
