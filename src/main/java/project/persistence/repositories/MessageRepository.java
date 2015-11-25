package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
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

}
