package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Rating;
import tn.esprit.tpfoyer.entity.Chambre;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByChambre(Chambre chambre);
    List<Rating> findByChambreOrderByRatingDateDesc(Chambre chambre);
    Double findAverageScoreByChambre(Chambre chambre);
} 