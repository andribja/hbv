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
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(columnDefinition="text")
    private String content;
    private long sendTime;
    private boolean read;

    @OneToOne
    private User sender;

    @OneToOne
    private User receiver;

    @OneToOne
    @JoinColumn(name="ad_id")
    private Ad relevantAd;

    public Message() {

    }

    public Message(String title, String content) {
        this.title = title;
        this.content = content;
        this.read = false;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public Timestamp getSendTimestamp() {
        return new Timestamp(sendTime);
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Ad getRelevantAd() {
        return relevantAd;
    }

    public void setRelevantAd(Ad relevantAd) {
        this.relevantAd = relevantAd;
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Ad = [name=%s, content=%s, sender=%s, receiver=%s, created=%s]",
                title, content, sender, receiver, this.getSendTimestamp());
    }
}
