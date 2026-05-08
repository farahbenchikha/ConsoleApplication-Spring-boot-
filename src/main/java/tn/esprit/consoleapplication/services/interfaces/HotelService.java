package tn.esprit.consoleapplication.services.interfaces;

import tn.esprit.consoleapplication.entities.*;

import java.util.List;

public interface HotelService {

    // ================= CLIENT =================

    boolean saveClient(Client client);

    boolean emailExists(String email);

    List<Client> getAllClients();

    Client getClientById(Long idClient);

    void deleteClient(Long idClient);

    // ================= ROOM TYPE =================

    RoomType saveRoomType(RoomType roomType);

    List<RoomType> getAllRoomTypes();

    // ================= ROOM =================

    Room saveRoom(Room room);

    List<Room> getAllRooms();

    Room getRoomById(Long idRoom);

    void deleteRoom(Long idRoom);

    // ================= RESERVATION =================

    Reservation saveReservation(Reservation reservation);

    List<Reservation> getAllReservations();

    Reservation getReservationById(Long idReservation);

    void deleteReservation(Long idReservation);

}