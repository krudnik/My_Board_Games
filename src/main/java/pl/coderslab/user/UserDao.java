package pl.coderslab.user;

import org.springframework.stereotype.Repository;
import pl.coderslab.game.Game;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    public void delete(User user) {
        User persistedUser = entityManager.contains(user) ? user : entityManager.merge(user);
        entityManager.remove(persistedUser);
    }

    public void update(User user) {
        entityManager.merge(user);
    }
}
