package relationship.hibernate.one_to_Many.unidirectional.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cricket_team_master")
public class CricketTeam {
    @Id
    @Column(name = "team_code")
    private String code;
    @Column(name = "team_name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id") //This is foreign key column in players table referring to primary key of teams table
    private Set<CricketPlayer> players;

    public CricketTeam(){
        players = new HashSet<>(); //Initializing the Set
    }

    public CricketTeam(String code, String name, Set<CricketPlayer> players) {
        this.code = code;
        this.name = name;
        this.players = players;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CricketPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<CricketPlayer> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "CricketTeam{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", players=" + players +
                '}';
    }

    public void addCricketPlayer(CricketPlayer player){
        //This is a convenient method to add one player at a time

        players.add(player);
    }
}
