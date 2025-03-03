package tn.esprit.tpfoyer.service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements IReservationService{

    ReservationRepository reservationRepository;


    @Scheduled(fixedRate = 50000) // Toutes les 50 secondes
    public void mettreAJourEtAfficherReservations() throws ParseException {
        // Date limite pour la mise à jour
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date limiteDate = formatter.parse("2024-01-01"); // Date statique pour comparaison

        // Récupérer toutes les réservations
        List<Reservation> reservations = reservationRepository.findAll();

        // Parcourir et mettre à jour si nécessaire
        for (Reservation reservation : reservations) {
            if (reservation.getAnneeUniversitaire().before(limiteDate)) { // Comparer les dates
                reservation.setEstValid(false); // Mise à jour du statut
                reservationRepository.save(reservation); // Sauvegarde dans la base
            }
        }

        // Initialize the collection before logging
        reservations.forEach(reservation -> {
            Hibernate.initialize(reservation.getEtudiantIds()); // Initialize the collection
            log.info("Reservation : {}", reservation);
        });
    }


    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long ReservationId){
        return reservationRepository.findById(ReservationId).get();
    }

    public Reservation addReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public void deleteReservationById(Long ReservationId){
        reservationRepository.deleteById(ReservationId);
    }

}
