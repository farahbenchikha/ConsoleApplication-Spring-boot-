package tn.esprit.consoleapplication.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.consoleapplication.entities.*;
import tn.esprit.consoleapplication.repositories.*;
import tn.esprit.consoleapplication.services.interfaces.HotelService;

import java.util.List;

@Service
@AllArgsConstructor

public class HotelServiceImpl implements HotelService {

    private final ClientRepository clientRepository;

    private final RoomRepository roomRepository;

    private final RoomTypeRepository roomTypeRepository;

    private final ReservationRepository reservationRepository;

    // ================= CLIENT =================

    @Override
    public boolean saveClient(Client client) {

        clientRepository.save(client);

        return true;
    }

    @Override
    public boolean emailExists(String email) {

        return clientRepository.existsByEmailClient(email);
    }

    @Override
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long idClient) {

        return clientRepository.findById(idClient)
                .orElse(null);
    }

    @Override
    public void deleteClient(Long idClient) {

        clientRepository.deleteById(idClient);
    }

    // ================= ROOM TYPE =================

    @Override
    public RoomType saveRoomType(RoomType roomType) {

        return roomTypeRepository.save(roomType);
    }

    @Override
    public List<RoomType> getAllRoomTypes() {

        return roomTypeRepository.findAll();
    }

    // ================= ROOM =================

    @Override
    public Room saveRoom(Room room) {

        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {

        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long idRoom) {

        return roomRepository.findById(idRoom)
                .orElse(null);
    }

    @Override
    public void deleteRoom(Long idRoom) {

        roomRepository.deleteById(idRoom);
    }

    // ================= RESERVATION =================

    @Override
    public Reservation saveReservation(Reservation reservation) {

        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {

        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long idReservation) {

        return reservationRepository.findById(idReservation)
                .orElse(null);
    }

    @Override
    public void deleteReservation(Long idReservation) {

        reservationRepository.deleteById(idReservation);
    }
}