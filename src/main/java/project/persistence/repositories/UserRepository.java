package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Ad;
import project.persistence.entities.PostitNote;
import project.persistence.entities.User;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

    User save(User User);

    void delete(User user);

    List<User> findAll();

    User findOne(String username);

    List<User> findByUsername(String username);


}
