package relationship.hibernate.Many_to_many.Bidirectional.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Actor_master")
public class Actor {  //This is the INVERSE side: Changes made in actor side is not reflected in database for there
    // inverse column
    @Id
    @Column(name = "actor_id")
    private int actorId;
    @Column(name = "actor_name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "actors")

    private Set<Movie> movies;
    public Actor(){}

    public Actor(int actorId, String name, Set<Movie> movies) {
        this.actorId = actorId;
        this.name = name;
        this.movies = movies;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "example.hibernate.many_to_many.bidirectional.entity.Actor{" +
                "actorId=" + actorId +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }

    //Method to add movies in Set<Movie> collection
    public void addMovie(Movie movie){
        movies.add(movie);
    }
}
