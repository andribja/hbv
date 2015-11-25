package project.service;

import project.persistence.entities.Ad;

import java.util.List;

public interface AdService {

    /**
     * Save a {@link Ad}
     * @param ad {@link Ad} to be saved
     * @return {@link Ad} that was saved
     */
    Ad save(Ad ad);

    /**
     * Delete {@link Ad}
     * @param ad {@link Ad} to be deleted
     */
    void delete(Ad ad);

    /**
     * Get all {@link Ad}s
     * @return A list of {@link Ad}s
     */
    List<Ad> findAll();

    /**
     * Get all {@link Ad}s in a reverse order
     * @return A reversed list of {@link Ad}s
     */
    List<Ad> findAllReverseOrder();

    /**
     * Find a {@link Ad} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link Ad} with {@link Long id}
     */
    Ad findOne(Long id);

    /**
     * Find all {@link Ad}s with {@link String name}
     * @param name {@link String}
     * @return All {@link Ad}s with the {@link String name} passed
     */
    List<Ad> findByName(String name);

    List<Ad> findByAuthor_id(Long username);

    List<Ad> findAllActive();

    List<Ad> findAllUnreviewedBy(Long user_id);
}
