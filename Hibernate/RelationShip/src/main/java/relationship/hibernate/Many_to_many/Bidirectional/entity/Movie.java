package relationship.hibernate.Many_to_many.Bidirectional.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "movie_master")
public class Movie {
    @Id
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "movie_title")
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Movie_Actor_Master",
            joinColumns = {@JoinColumn(name = "m_id")},
            inverseJoinColumns = {@JoinColumn(name = "a_id")}
            )
    private Set<Actor> actors;
    public Movie(){}  //Default constructor

    public Movie(int movieId, String title, Set<Actor> actors) {
        this.movieId = movieId;
        this.title = title;
        this.actors = actors;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        for(Actor actor : actors){
            actor.addMovie(this);
        }
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "example.hibernate.many_to_many.bidirectional.entity.Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", actors=" + actors +
                '}';
    }

    //Method to add single actor in Set<Actor> collection
    public void addActor(Actor actor){
        actor.addMovie(this);  //Setting the other end as well
        actors.add(actor);
    }
}
