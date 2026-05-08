package tn.esprit.consoleapplication.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "reservations")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate checkInDateReservation;
    private LocalDate checkOutDateReservation;
    private Double totalPriceReservation;
    @Enumerated(EnumType.STRING)
    private ReservationStatus statusReservation;
    private LocalDateTime createdAtReservation;
    @ManyToOne
    @ToString.Exclude
    private Client client;
    @ManyToOne
    @ToString.Exclude
    private Room room;

}
