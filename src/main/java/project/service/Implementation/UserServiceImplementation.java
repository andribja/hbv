package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;
import project.service.UserService;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    // Instance Variables
    UserRepository repository;

    // Dependency Injection
    @Autowired
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAllReverseOrder() {
        // Get all users
        List<User> users = repository.findAll();

        // Reverse the list
        Collections.reverse(users);

        return users;
    }

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }


    @Override
    public User findByUsername(String username) {
        return repository.findOneByUsername(username);
    }


    @Override
    public boolean exists(Long id) {
        return repository.exists(id);
    }

    @Override
    public double getRatingFor(Long id) {
        return repository.getRatingFor(id);
    }
}
