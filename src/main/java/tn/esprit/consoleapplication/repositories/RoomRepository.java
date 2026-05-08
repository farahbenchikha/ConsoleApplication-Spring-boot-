package tn.esprit.consoleapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.consoleapplication.entities.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
