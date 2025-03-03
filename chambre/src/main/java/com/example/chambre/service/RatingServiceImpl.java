package tn.esprit.tpfoyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.tpfoyer.entity.Rating;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repository.RatingRepository;
import tn.esprit.tpfoyer.repository.ChambreRepository;

import java.util.Date;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Rating addRating(Long chambreId, Rating rating) {
        if (rating.getScore() < 1 || rating.getScore() > 5) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rating score must be between 1 and 5");
        }

        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Chamber with ID " + chambreId + " not found. Please create the chamber first."
                ));

        rating.setChambre(chambre);
        rating.setRatingDate(new Date());

        // Update chamber's average rating
        Double currentAvg = chambre.getAverageRating();
        Integer totalRatings = chambre.getTotalRatings();
        
        Double newAvg = ((currentAvg * totalRatings) + rating.getScore()) / (totalRatings + 1);
        
        chambre.setAverageRating(newAvg);
        chambre.setTotalRatings(totalRatings + 1);
        
        chambreRepository.save(chambre);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getChambreRatings(Long chambreId) {
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Chamber with ID " + chambreId + " not found"
                ));
        return ratingRepository.findByChambre(chambre);
    }

    @Override
    public Double getAverageRating(Long chambreId) {
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Chamber with ID " + chambreId + " not found"
                ));
        return chambre.getAverageRating();
    }

    @Override
    public List<Rating> getRecentRatings(Long chambreId) {
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Chamber with ID " + chambreId + " not found"
                ));
        return ratingRepository.findByChambreOrderByRatingDateDesc(chambre);
    }

    @Override
    public void deleteRating(Long ratingId) {
        Rating rating = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "Rating with ID " + ratingId + " not found"
                ));
        
        Chambre chambre = rating.getChambre();
        Integer totalRatings = chambre.getTotalRatings();
        
        if (totalRatings > 1) {
            Double currentAvg = chambre.getAverageRating();
            Double newAvg = ((currentAvg * totalRatings) - rating.getScore()) / (totalRatings - 1);
            chambre.setAverageRating(newAvg);
        } else {
            chambre.setAverageRating(0.0);
        }
        
        chambre.setTotalRatings(totalRatings - 1);
        chambreRepository.save(chambre);
        ratingRepository.deleteById(ratingId);
    }
} 