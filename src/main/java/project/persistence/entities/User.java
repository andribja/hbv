package project.persistence.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

/**
 * The class for the User.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "users") // If you want to specify a table name, you can do so here
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String hash;
    private double rating;
    private int numRatings;

    public User() {

    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;

        rating = 0;
        numRatings = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void giveRating(double rating) {

        this.rating = (this.rating*numRatings + rating) / ++numRatings;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "User = [username=%s, email=%s, number of ratings=%s, rating=%s]",
                username, email, numRatings, rating);
    }
}
