package relationship.hibernate.one_to_Many.unidirectional.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "cricket_player_master")
public class CricketPlayer {
    @Id
    @Column(name = "player_id")
    private int playerId;
    @Column(name = "player_name")
    private String name;
    @Column(name = "player_age")
    private int age;
    public CricketPlayer(){}

    public CricketPlayer(int playerId, String name, int age) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CricketPlayer{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CricketPlayer that)) return false;
        return getPlayerId() == that.getPlayerId() && getAge() == that.getAge() && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayerId(), getName(), getAge());
    }
}
