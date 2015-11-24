package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.Ad;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad save(Ad ad);

    void delete(Ad ad);

    List<Ad> findAll();

    // Instead of the method findAllReverseOrder() in PostitNoteService.java,
    // We could have used this method by adding the words
    // ByOrderByIdDesc, which mean: Order By Id in a Descending order
    //
    List<Ad> findAllByOrderByIdDesc();

    Ad findOne(Long id);

    List<Ad> findByName(String name);

    List<Ad> findByAuthor_id(Long user_id);
}
