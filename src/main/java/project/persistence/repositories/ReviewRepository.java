package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Review;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review save(Review message);

    void delete(Review message);

    List<Review> findAll();

    // Instemessage of the method findAllReverseOrder() in PostitNoteService.java,
    // We could have used this method by messageding the words
    // ByOrderByIdDesc, which mean: Order By Id in a Descending order
    //
    List<Review> findAllByOrderByIdDesc();

    Review findOne(Long id);

    List<Review> findBySender(Long senderId);

    List<Review> findByReceiverId(Long receiverId);

}
