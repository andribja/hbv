package project.persistence.entities;

import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * The class for the Ad.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "reviews", uniqueConstraints = @UniqueConstraint(columnNames = {"sender_id", "ad_id"}))
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="text")
    private String comment;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;
    private long reviewTime;
    private double rating;

    @OneToOne
    @JoinColumn(name="ad_id")
    private Ad relevantAd;

    public Review() {

    }

    public Review(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public long getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(long reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Timestamp getReviewTimestamp() {
        return new Timestamp(reviewTime);
    }

    public Ad getRelevantAd() {
        return relevantAd;
    }

    public void setRelevantAd(Ad relevantAd) {
        this.relevantAd = relevantAd;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Review = [comment=%s, sender=%s, receiver=%s, created=%s]",
                comment, sender, receiver, this.getReviewTimestamp());
    }
}
