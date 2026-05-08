package tn.esprit.consoleapplication.entities;

import jakarta.persistence.*;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "roomtype")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoomType;
    private String nameRoomType;
    private String descriptionRoomType;

    @OneToMany(mappedBy = "roomType")
    @ToString.Exclude
    private List<Room> rooms;
}
