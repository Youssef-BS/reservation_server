package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Rating;
import tn.esprit.tpfoyer.entity.Chambre;
import java.util.List;

public interface RatingService {
    Rating addRating(Long chambreId, Rating rating);
    List<Rating> getChambreRatings(Long chambreId);
    Double getAverageRating(Long chambreId);
    List<Rating> getRecentRatings(Long chambreId);
    void deleteRating(Long ratingId);
} 