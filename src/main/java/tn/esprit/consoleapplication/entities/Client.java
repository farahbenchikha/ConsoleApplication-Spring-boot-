package tn.esprit.consoleapplication.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clients")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;


    private String firstNameClient;


    private String lastNameClient;


    private String emailClient;


    private String phoneClient;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private List<Reservation> reservations;
}
