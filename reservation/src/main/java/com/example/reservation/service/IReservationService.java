package com.example.reservation.service;

import java.util.Date;
import java.util.List;
import com.example.reservation.entity.Reservation;

public interface IReservationService {

    public List<Reservation> getAllReservations();
    public Reservation getReservationById(Long ReservationId);
    public Reservation addReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservationById(Long ReservationId);
    List<Reservation> searchReservations(Date reservationDate, String keyword, Boolean status);


}
