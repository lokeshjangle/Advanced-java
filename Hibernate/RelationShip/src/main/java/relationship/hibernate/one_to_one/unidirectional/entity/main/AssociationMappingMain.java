package relationship.hibernate.one_to_one.unidirectional.entity.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import relationship.hibernate.one_to_one.unidirectional.entity.Employee;
import relationship.hibernate.one_to_one.unidirectional.entity.Passport;
import relationship.hibernate.one_to_one.unidirectional.entity.utils.HibernateUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class AssociationMappingMain {

    private static void addPassport(){
        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session = factory.openSession();
                Scanner sc = new Scanner(System.in);
        ){
            System.out.println("Enter Passport Number:");
            String pno = sc.nextLine();
            System.out.println("Enter Passport Holder Name:");
            String name = sc.nextLine();
            System.out.println("Enter expiry date in YYYY/MM/DD");
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            //Passport passport1 = new Passport("P01","Lokesh Jangale", LocalDate.of(2027,8,12));
            //Passport passport2 = new Passport("P02","Sainath Thakare",LocalDate.of(2028,5,10));
            Passport passport = new Passport(pno,name,LocalDate.of(year,month,day));
            Transaction tx = session.beginTransaction();
            //session.persist(passport1);
            //session.persist(passport2);
            session.persist(passport);
            tx.commit();
        }
    }
    private static void addEmployee(){
        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session = factory.openSession();
                Scanner sc = new Scanner(System.in);
                ){
            System.out.println("Enter Employee Id:");
            int empId = sc.nextInt();
            System.out.println("Enter Employee Name:");
            String ename = sc.next();
            System.out.println("Enter Employee Salary");
            int sal = sc.nextInt();
            //Employee emp1 = new Employee(101,"Lokesh Jangale", 50000,null);
            //Employee emp2 = new Employee(102,"Sai Thakare",45000,null);
            Employee emp = new Employee(empId,ename,sal,null);
            Transaction tx = session.beginTransaction();
            //session.persist(emp1);
            //session.persist(emp2);
            session.persist(emp);
            tx.commit();
        }
    }
    private static void linkPassportToEmployee(){
        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session = factory.openSession();
                Scanner sc = new Scanner(System.in);
        ){
            //Find all the passport
            Passport firstPassport = session.find(Passport.class,"P01");
            Passport secondPassport = session.find(Passport.class,"P02");
            Passport thirdPassport = session.find(Passport.class,"P03");

            //Find all the employee
            Employee firstEmployee = session.find(Employee.class,101);
            Employee secondEmployee = session.find(Employee.class,102);
            Employee thirdEmployee = session.find(Employee.class,103);

            //Link passport to employee
            Transaction tx = session.beginTransaction();
            firstEmployee.setPassportDetails(firstPassport);
            secondEmployee.setPassportDetails(secondPassport);
            thirdEmployee.setPassportDetails(thirdPassport);
            tx.commit();
        }
    }
    public static void main(String[] args){
        //addPassport();
        //addEmployee();
        linkPassportToEmployee();
    }
}
