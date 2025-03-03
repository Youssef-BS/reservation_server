package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    // @Query("SELECT c FROM Chambre c JOIN c.reservations r JOIN r.etudiants e WHERE e.cin = :cin")
    // Chambre findChambreByEtudiantCin(@Param("cin") Long cin);
}
