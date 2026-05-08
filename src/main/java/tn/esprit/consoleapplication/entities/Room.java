package tn.esprit.consoleapplication.entities;

import jakarta.persistence.*;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "room")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoom;
    private String roomNumber;
    private Integer floorRoom;
    private Integer capacityRoom;
    private Double pricePerNightRoom;

    @Enumerated(EnumType.STRING)
    private RoomStatus statusRoom;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @OneToMany(mappedBy = "room")
    @ToString.Exclude
    private List<Reservation> reservations;
}
