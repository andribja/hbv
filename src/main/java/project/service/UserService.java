package project.service;

import project.persistence.entities.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(User user);

    List<User> findAll();

    List<User> findAllReverseOrder();

    User findOne(Long id);

    User findByUsername(String username);

    boolean exists(Long id);

    double getRatingFor(Long id);

}
