package project.persistence.entities;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;
import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import javax.persistence.Parameter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * The class for the Ad.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Indexed
@Table(name = "ads")
@AnalyzerDef(name = "customanalyzer",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = LowerCaseFilterFactory.class)
        })
public class Ad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String name;
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Column(columnDefinition="text")
    private String content;
    private long creationTime;

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
