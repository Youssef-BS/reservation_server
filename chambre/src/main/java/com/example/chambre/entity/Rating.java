package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RATING")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer score; // Rating score (1-5)

    @Column
    private String comment; // Optional comment

    @Column(nullable = false)
    private String userIdentifier; // To identify who gave the rating

    @ManyToOne
    @JoinColumn(name = "chambre_id", nullable = false)
    private Chambre chambre;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ratingDate;

    public Rating() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }
} 