package project.persistence.repositories;

//import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.persistence.entities.Ad;

import java.math.BigInteger;
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


//    @Query(value = "SELECT ad FROM Ad ad " +
//                        "WHERE (ad.buyer.id IS NOT NULL AND (ad.buyer.id=?1 OR ad.author.id=?1)) AND ad.id NOT IN " +
//                            "(SELECT r.relevantAd.id FROM Review r WHERE (r.sender.id=?1))")
//    @Query(value = "SELECT m.relevantAd FROM Message m WHERE (m.receiver.id=?1 AND m.relevantAd.id NOT IN (SELECT r.relevantAd.id FROM Review r WHERE r.sender.id=?1))")
    @Query(value = "select distinct m1.ad_id from messages m1 cross join messages m2 where (m1.sender_id=?1 AND m1.receiver_id=m2.sender_id AND m2.receiver_id=m1.sender_id) AND NOT EXISTS (SELECT 1 FROM reviews WHERE ad_id=m1.ad_id AND sender_id=m1.sender_id);", nativeQuery = true)
    List<BigInteger> findAllUnreviewedIds(Long user_id);

}
