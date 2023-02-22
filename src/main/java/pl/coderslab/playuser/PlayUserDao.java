package pl.coderslab.playuser;

import org.springframework.stereotype.Repository;
import pl.coderslab.play.Play;
import pl.coderslab.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlayUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePlay(PlayUser playUser) {
        entityManager.persist(playUser);
    }

    public PlayUser findById(long id) {
        return entityManager.find(PlayUser.class, id);
    }
    public List<PlayUser> findAll() {
        TypedQuery<PlayUser> query = entityManager.createQuery("select pu from PlayUser pu", PlayUser.class);
        List<PlayUser> playUsers = query.getResultList();
        return playUsers;
    }
}
