package com.example.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.reservation.entity.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r " +
            "WHERE (:reservationDate IS NULL OR r.reservationDate = :reservationDate) " +
            "AND (:keyword IS NULL OR LOWER(r.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND (:status IS NULL OR r.status = :status)")
    List<Reservation> search(Date reservationDate, String keyword, Boolean status);
}
