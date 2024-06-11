
import com.mycompany.ejb.UserService;
import com.mycompany.jpa.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



@Stateless
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User authenticate(String username, String password) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void register(User user) {
        em.persist(user);
    }
}
