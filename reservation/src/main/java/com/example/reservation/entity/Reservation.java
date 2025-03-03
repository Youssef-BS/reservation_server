package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

// Remove the import statement for Etudiant
// import tn.esprit.tpfoyer.entity.Etudiant; // Not needed anymore

@Entity
@Getter
@Setter
@Table(name="RESERVATION")
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @Column(name="ID_RESERVATION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(name="ANNEE_UNIVERSITAIRE")
    private Date anneeUniversitaire;

    @Column(name="STATUS")
    private boolean estValid;

    // Change back to ElementCollection
    @ElementCollection
    @CollectionTable(name = "reservation_etudiant_ids", joinColumns = @JoinColumn(name = "reservation_id"))
    @Column(name="ETUDIANT_ID")
    private Set<Long> etudiantIds; // Store IDs instead of Etudiant objects

    @Override
    public String toString() {
        return "Reservation [idReservation=" + idReservation + ", anneeUniversitaire=" + anneeUniversitaire + ", estValid=" + estValid + ", etudiantIds=" + etudiantIds + "]";
    }
}
