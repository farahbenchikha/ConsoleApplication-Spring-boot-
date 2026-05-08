package tn.esprit.consoleapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.consoleapplication.entities.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {
}
