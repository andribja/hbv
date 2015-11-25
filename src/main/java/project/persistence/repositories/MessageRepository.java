package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Message;
import project.persistence.entities.User;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

    Message save(Message message);

    void delete(Message message);

    List<Message> findAll();

    // Instemessage of the method findAllReverseOrder() in PostitNoteService.java,
    // We could have used this method by messageding the words
    // ByOrderByIdDesc, which mean: Order By Id in a Descending order
    //
    List<Message> findAllByOrderByIdDesc();

    Message findOne(Long id);

    List<Message> findBySender(String sender);

    List<Message> findByReceiverId(Long receiverId);

    @Query("SELECT m.sender FROM Message m WHERE m.relevantAd.id=?1")
    List<User> findAllInterested(Long adId);

    // SELECT sender_id from messages where ad_id=1 order by id LIMIT 1;
    @Query(value = "SELECT m.sender FROM Message m WHERE m.relevantAd.id=?1 AND m.id=(SELECT MIN(m1.id) FROM Message m1 WHERE m1.relevantAd.id=?1)")
    //@Query(value = "SELECT sender_id from messages where ad_id=1 AND id=(SELECT MIN(id) from messages WHERE ad_id=1)", nativeQuery = true)
    User findOriginalMessageUser(Long adId);

    @Query(value = "SELECT m FROM Message m WHERE m.read=false")
    List<Message> getUnreadMessagesByUserId(Long userId);
}
