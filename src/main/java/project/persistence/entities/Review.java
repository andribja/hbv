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
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="text")
    private String comment;

    @OneToOne
    private User sender;

    @OneToOne
    private User receiver;

    private long reviewTime;

    public Review() {

    }

    public Review(String comment, User sender, User receiver) {
        this.comment = comment;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return comment;
    }

    public void setContent(String comment) {
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

    public long getSendTime() {
        return reviewTime;
    }

    public void setSendTime(long reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Timestamp getSendTimestamp() {
        return new Timestamp(reviewTime);
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Review = [comment=%s, sender=%s, receiver=%s, created=%s]",
                comment, sender, receiver, this.getSendTimestamp());
    }
}
