package tn.esprit.tpfoyer.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;
import java.util.List;


@Tag(name="gestion de reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    IReservationService reservationService;

    // http://localhost:8089/tpfoyer/reservation/get-all-reservations
    @Operation(description="recuperer toutes les reservations de db")
    @GetMapping("/get-all-reservations")
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    // http://localhost:8089/tpfoyer/reservation/get-reservation/1
    @Operation(description="recuperer les reservations by id")
    @GetMapping("/get-reservation/{reservationId}")
    public Reservation getReservation(@PathVariable Long reservationId){
        return reservationService.getReservationById(reservationId);
    }


    // http://localhost:8089/tpfoyer/reservation/add-reservation
    @Operation(description="ajouter des reservations")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }

    // http://localhost:8089/tpfoyer/reservation/update-reservation
    @Operation(description="modifier des reservations")
    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }

    // http://localhost:8089/tpfoyer/reservation/delete-reservarion/1
    @Operation(description="supprimer des reservations by id")
    @DeleteMapping("/delete-reservation/{reservationID}")
    public void deleteReservation(@PathVariable Long reservationID){
        reservationService.deleteReservationById(reservationID);
    }

}
