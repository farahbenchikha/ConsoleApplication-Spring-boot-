package tn.esprit.consoleapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.consoleapplication.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    boolean existsByEmailClient(String emailClient);

}
