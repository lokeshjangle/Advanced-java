package relationship.hibernate.one_to_Many.unidirectional.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import relationship.hibernate.one_to_Many.unidirectional.entity.CricketPlayer;
import relationship.hibernate.one_to_Many.unidirectional.entity.CricketTeam;
import relationship.hibernate.one_to_Many.unidirectional.utils.HibernateUtils;

import java.util.Set;

public class AssociationMappingOneToManyMain {
    private static void addCricketTeams(){
        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session = factory.openSession();
                ){
            CricketTeam teamIndia = new CricketTeam("IND","INDIA",null);
            CricketTeam teamAustralia = new CricketTeam("AUS","AUSTRALIA",null);
            Transaction tx = session.beginTransaction();
            session.persist(teamIndia);
            session.persist(teamAustralia);
            tx.commit();
        }
    }
    private static void addCricketPlayer(){
        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session = factory.openSession();
                ) {
            CricketPlayer indPlayer1 = new CricketPlayer(45, "Rohit Sharma", 37);
            CricketPlayer indPlayer2 = new CricketPlayer(18, "Virat Kohli", 38);
            CricketPlayer indPlayer3 = new CricketPlayer(22, "Ravindra Jadega", 35);

            CricketPlayer ausPlayer1 = new CricketPlayer(43, "Travis Head", 31);
            CricketPlayer ausPlayer2 = new CricketPlayer(21, "Pat Cummins", 34);

            Transaction tx = session.beginTransaction();
            session.persist(indPlayer1);
            session.persist(indPlayer2);
            session.persist(indPlayer3);
            session.persist(ausPlayer1);
            session.persist(ausPlayer2);
            tx.commit();
        }
    }
    private static void linkPlayersToTeam(){

        try(
                SessionFactory factory = HibernateUtils.getSessionFactory();
                Session session = factory.openSession();
                ){
            //Find all players
            CricketPlayer player1 = session.find(CricketPlayer.class,45);
            CricketPlayer player2 = session.find(CricketPlayer.class,18);
            CricketPlayer player3 = session.find(CricketPlayer.class,22);
            CricketPlayer player4 = session.find(CricketPlayer.class,21);
            CricketPlayer player5 = session.find(CricketPlayer.class,43);

            //Find all teams
            CricketTeam team1 = session.find(CricketTeam.class,"IND");
            CricketTeam team2 = session.find(CricketTeam.class,"AUS");

            //Link players and team
            Set<CricketPlayer> indianPlayer =  Set.of(player1,player2,player3);
            Transaction tx = session.beginTransaction();
            team1.setPlayers(indianPlayer);
            team2.addCricketPlayer(player4);
            team2.addCricketPlayer(player5);
            tx.commit();
        }
    }
    public static void main(String[] args) {
        //addCricketTeams();
        //addCricketPlayer();
        linkPlayersToTeam();
    }
}
