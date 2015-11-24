package project.persistence.entities;

import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Store;

/**
 * The class for the Ad.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Indexed
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Field
    private String name;
    @Field
    @Column(columnDefinition="text")
    private String content;
    private long creationTime;

    @Field
    @OneToOne
    @JoinColumn(name="author_id")
    private User author;

    public Ad() {
        
    }

    public Ad(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long time) {
        creationTime = time;
    }

    public Timestamp getCreationTimestamp() {
        return new Timestamp(creationTime);
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Ad = [name=%s, content=%s, created=%s]",
                name, content, this.getCreationTimestamp());
    }
}
