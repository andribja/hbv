package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Review;
import project.persistence.repositories.ReviewRepository;
import project.service.ReviewService;
import project.service.ReviewService;

import java.util.Collections;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {

    // Instance Variables
    ReviewRepository repository;

    // Dependency Injection
    @Autowired
    public ReviewServiceImplementation(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Review save(Review review) {
        return repository.save(review);
    }

    @Override
    public void delete(Review review) {
        repository.delete(review);
    }

    @Override
    public List<Review> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Review> findAllReverseOrder() {
        // Get all the Reviews
        List<Review> reviews = repository.findAll();

        // Reverse the list
        Collections.reverse(reviews);

        return reviews;
    }

    @Override
    public Review findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Review> findBySender(String sender) {
        return repository.findBySender(sender);
    }

    @Override
    public List<Review> findByReceiver(String receiver) {
        return repository.findByReceiver(receiver);
    }
}
