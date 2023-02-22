package pl.coderslab.playuser;

import pl.coderslab.game.Game;
import pl.coderslab.play.Play;
import pl.coderslab.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class PlayUser {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    private Play play;
    @ManyToOne
    private User user;
    private int points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "PlayUser{" +
                "id=" + id +
//                ", play=" + play +
//                ", user=" + user +
                ", points=" + points +
                '}';
    }
}
