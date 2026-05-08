package tn.esprit.consoleapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.consoleapplication.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
