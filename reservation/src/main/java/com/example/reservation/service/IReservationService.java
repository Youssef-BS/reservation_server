package tn.esprit.tpfoyer.service;
import tn.esprit.tpfoyer.entity.Reservation;
import java.util.List;


public interface IReservationService {

    public List<Reservation> getAllReservations();
    public Reservation getReservationById(Long ReservationId);
    public Reservation addReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservationById(Long ReservationId);

}
