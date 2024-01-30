package example.hibernate.hql;

import example.hibernate.programmatic.bean.RestaurantNameAndCuisine;
import example.hibernate.programmatic.entity.Restaurant;
import example.hibernate.programmatic.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HQLExampleMain {
    private static  void fromClauseExample(){
        try(SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();){
            //Building HQL query string
            String hqlQuery = "from Restaurant rs";
            //Obtaining query reference
            Class<Restaurant> entityClassType = Restaurant.class;
            Query<Restaurant> queryRef = session.createQuery(hqlQuery,entityClassType);  //Create a query for hql by using query_string and class_type
            List<Restaurant> allRestaurant = queryRef.getResultList();  //fetching data from database using hql query

//            for(Restaurant rs : allRestaurant){
//                System.out.println(rs);
//            }
            allRestaurant.stream().forEach(rst-> System.out.println(rst));
        }
    }
        //SELECT clause example
        private static void selectClauseExample(){
            try( SessionFactory factory = HibernateUtils.getSessionFactory();
                  Session session = factory.openSession();){
                //Building HQL query using SELECT clause
                String hqlQuery = "select rs.name,rs.branchCount from Restaurant rs";
                //obtaining query reference
                Query<Object[]> queryRef = session.createQuery(hqlQuery,Object[].class);
                List<Object[]> dataList = queryRef.getResultList();
                //dataList.stream().forEach(rst-> System.out.println("Restaurant " + rst[0] + " has " + rst[1] + " branches"));
                for(Object[] values : dataList){
                    Object name = values[0];  //0 stands for 1st value from record
                    Object brCount = values[1];
                    System.out.println("Restaurant " + name + " has " + brCount + " branches");
                }
            }
        }

        //Constructor Expression Example
    private static void constructorExpressionExample(){
        try (
            SessionFactory factory = HibernateUtils.getSessionFactory();
            Session session = factory.openSession();
        ){
            String hqlQuery = "select new example.hibernate.programmatic.bean.RestaurantNameAndCuisine(rs.name,rs.cuisine) from Restaurant rs";
            Query<RestaurantNameAndCuisine> queryRef = session.createQuery(hqlQuery,RestaurantNameAndCuisine.class);
            List<RestaurantNameAndCuisine> dataList = queryRef.getResultList();
            for(RestaurantNameAndCuisine nameAndCousine : dataList){
                System.out.println(nameAndCousine);
            }
        }
    }

    public static void main(String[] args){
        //fromClauseExample();
        //selectClauseExample();
        constructorExpressionExample();
    }
}
