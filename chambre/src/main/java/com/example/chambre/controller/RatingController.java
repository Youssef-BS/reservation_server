package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Rating;
import tn.esprit.tpfoyer.service.RatingService;

import java.util.List;

@Tag(name = "Gestion des notes")
@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Operation(description = "Ajouter une note pour une chambre")
    @PostMapping("/add/{chambreId}")
    public ResponseEntity<Rating> addRating(
            @PathVariable Long chambreId,
            @RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.addRating(chambreId, rating));
    }

    @Operation(description = "Obtenir toutes les notes d'une chambre")
    @GetMapping("/chambre/{chambreId}")
    public ResponseEntity<List<Rating>> getChambreRatings(@PathVariable Long chambreId) {
        return ResponseEntity.ok(ratingService.getChambreRatings(chambreId));
    }

    @Operation(description = "Obtenir la note moyenne d'une chambre")
    @GetMapping("/average/{chambreId}")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long chambreId) {
        return ResponseEntity.ok(ratingService.getAverageRating(chambreId));
    }

    @Operation(description = "Obtenir les notes récentes d'une chambre")
    @GetMapping("/recent/{chambreId}")
    public ResponseEntity<List<Rating>> getRecentRatings(@PathVariable Long chambreId) {
        return ResponseEntity.ok(ratingService.getRecentRatings(chambreId));
    }

    @Operation(description = "Supprimer une note")
    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.ok().build();
    }
} 