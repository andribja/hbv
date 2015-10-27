package project.service;

import project.persistence.entities.User;

import java.util.List;

public interface UserService {

    /**
     * Save a {@link User}
     * @param user {@link User} to be saved
     * @return {@link User} that was saved
     */
    User save(User user);

    /**
     * Delete {@link User}
     * @param user {@link User} to be deleted
     */
    void delete(User user);

    /**
     * Get all {@link User}s
     * @return A list of {@link User}s
     */
    List<User> findAll();

    /**
     * Get all {@link User}s in a reverse order
     * @return A reversed list of {@link User}s
     */
    List<User> findAllReverseOrder();

    /**
     * Find a {@link User} based on {@link String username}
     * @param username {@link String}
     * @return A {@link User} with {@link String username}
     */
    User findOne(String username);

    /**
     * Find all {@link User}s with {@link String username}
     * @param username {@link String}
     * @return All {@link User}s with the {@link String username} passed
     */
    List<User> findByUsername(String username);


    boolean exists(String username);

}
