package pl.coderslab.play;

import org.springframework.stereotype.Repository;
import pl.coderslab.game.Game;
import pl.coderslab.playuser.PlayUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlayDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePlay(Play play) {
        entityManager.persist(play);
    }

    public List<Play> findAll() {
        TypedQuery<Play> query = entityManager.createQuery("select p from Play p", Play.class);
        List<Play> plays = query.getResultList();
        return plays;
    }

    public Play findById(long id) {
        Play play = entityManager.find(Play.class, id);
        return play;
    }
}
