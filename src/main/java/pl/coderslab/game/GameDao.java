package pl.coderslab.game;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.playuser.PlayUser;
import pl.coderslab.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class GameDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveGame(Game game) {
        entityManager.persist(game);
    }

    public List<Game> findAll() {
        TypedQuery<Game> query = entityManager.createQuery("select g from Game g", Game.class);
        List<Game> games = query.getResultList();
        return games;
    }

    public Game findById(long id) {
        Game game = entityManager.find(Game.class, id);
        return game;
    }
    public void delete(Game game) {
        Game persistedGame = entityManager.contains(game) ? game : entityManager.merge(game);
        entityManager.remove(persistedGame);
    }

    public void update(Game game) {
        entityManager.merge(game);
    }

    public List<PlayUser> maxPoints(Game game){
        TypedQuery<PlayUser> query = entityManager.createQuery("select pu from PlayUser pu where pu.play.game = :game order by pu.points desc", PlayUser.class);
        query.setMaxResults(1);
        query.setParameter("game", game);
        return query.getResultList();

    }

    public Double avgPoints(Game game){
        Query query = entityManager.createQuery("select avg(pu.points) from PlayUser pu where pu.play.game = :game");
        query.setParameter("game", game);
        Double average = (Double) query.getSingleResult();
        return average;
    }

}
