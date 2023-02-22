package pl.coderslab.game;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
