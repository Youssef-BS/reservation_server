package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="CHAMBRE")
public class Chambre {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idChambre;

    @Column(name="NUMERO_CHAMBRE")
    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    @Column(name="TYPE_CHAMBRE")
    private TypeChambre typeC;

    @Column(name="AVERAGE_RATING")
    private Double averageRating = 0.0;

    @Column(name="TOTAL_RATINGS")
    private Integer totalRatings = 0;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    public Chambre() {}

    public Long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public Long getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(Long numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public TypeChambre getTypeC() {
        return typeC;
    }

    public void setTypeC(TypeChambre typeC) {
        this.typeC = typeC;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }
}

