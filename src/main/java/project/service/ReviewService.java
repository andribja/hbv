package project.service;

import project.persistence.entities.Review;

import java.util.List;

public interface ReviewService {

    Review save(Review review);

    void delete(Review review);

    List<Review> findAll();

    List<Review> findAllReverseOrder();

    Review findOne(Long id);

    List<Review> findBySender(String sender);

    List<Review> findByReceiver(String receiver);

}
