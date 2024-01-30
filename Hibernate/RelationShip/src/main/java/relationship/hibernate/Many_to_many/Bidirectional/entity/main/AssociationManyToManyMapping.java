package relationship.hibernate.Many_to_many.Bidirectional.entity.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import relationship.hibernate.Many_to_many.Bidirectional.entity.Actor;
import relationship.hibernate.Many_to_many.Bidirectional.entity.Movie;
import relationship.hibernate.Many_to_many.Bidirectional.entity.utils.HibernateUtils;

import java.util.Set;

public class AssociationManyToManyMapping {
    private static void addMovies(){
        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session = factory.openSession();
                ){
            Movie m1 = new Movie(1,"PK",null);
            Movie m2 = new Movie(2,"Dangal",null);
            Movie m3 = new Movie(3,"Animal",null);

            Transaction tx = session.beginTransaction();
            session.persist(m1);
            session.persist(m2);
            session.persist(m3);
            tx.commit();
        }
    };
    private static void addActors(){
        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session = factory.openSession();
                ){
            Actor a1 = new Actor(101,"Aamir Khan",null);
            Actor a2 = new Actor(102,"Anushka Sharma",null);
            Actor a3 = new Actor(103,"Ranbir Kapoor",null);

            Transaction tx = session.beginTransaction();
            session.persist(a1);
            session.persist(a2);
            session.persist(a3);
            tx.commit();
        }
    }
    private static void linkMovieToActor(){
        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session =  factory.openSession();
                ){
            //Find of movie
            Movie m1 = session.find(Movie.class,1);
            Movie m2 = session.find(Movie.class,2);
            Movie m3 = session.find(Movie.class,3);

            //Find actors
            Actor a1 = session.find(Actor.class,101);
            Actor a2 = session.find(Actor.class,102);
            Actor a3 = session.find(Actor.class,103);

            //linking movie to actor
            Transaction tx = session.beginTransaction();
             m1.setActors(Set.of(a1,a2));
             m2.addActor(a1);
             m3.addActor(a3);
            tx.commit();
        }
    }
    public static void main(String[] args) {
//        addMovies();
        //addActors();
        linkMovieToActor();
    }
}
