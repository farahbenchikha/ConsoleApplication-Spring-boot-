package tn.esprit.consoleapplication.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.consoleapplication.entities.*;
import tn.esprit.consoleapplication.services.interfaces.HotelService;

@Component
@AllArgsConstructor

public class HotelController {

    private final HotelService hotelService;

    // ================= CLIENT =================

    public void addClient(Client client) {

        boolean saved = hotelService.saveClient(client);

        if(saved) {

            System.out.println("Client added successfully.");

        } else {

            System.out.println("Client not added.");
        }
    }

    public void displayAllClients() {

        hotelService.getAllClients()
                .forEach(System.out::println);
    }

    public void displayClientById(Long idClient) {

        Client client =
                hotelService.getClientById(idClient);

        if (client != null) {

            System.out.println(client);

        } else {

            System.out.println("Client not found.");
        }
    }

    public void deleteClient(Long idClient) {

        hotelService.deleteClient(idClient);

        System.out.println("Client deleted successfully.");
    }

    // ================= ROOM TYPE =================

    public void addRoomType(RoomType roomType) {

        hotelService.saveRoomType(roomType);

        System.out.println("Room type added successfully.");
    }

    public void displayAllRoomTypes() {

        hotelService.getAllRoomTypes()
                .forEach(System.out::println);
    }

    // ================= ROOM =================

    public void addRoom(Room room) {

        hotelService.saveRoom(room);

        System.out.println("Room added successfully.");
    }

    public void displayAllRooms() {

        hotelService.getAllRooms().forEach(room -> {

            System.out.println("\n-------------------");

            System.out.println("ID : " + room.getIdRoom());
            System.out.println("Room Number : " + room.getRoomNumber());
            System.out.println("Floor : " + room.getFloorRoom());
            System.out.println("Capacity : " + room.getCapacityRoom());
            System.out.println("Price : " + room.getPricePerNightRoom());
            System.out.println("Status : " + room.getStatusRoom());

            System.out.println("-------------------");
        });
    }

    public void displayRoomById(Long idRoom) {

        Room room =
                hotelService.getRoomById(idRoom);

        if (room != null) {

            System.out.println(room);

        } else {

            System.out.println("Room not found.");
        }
    }

    public void deleteRoom(Long idRoom) {

        hotelService.deleteRoom(idRoom);

        System.out.println("Room deleted successfully.");
    }

    // ================= RESERVATION =================

    public void addReservation(Reservation reservation) {

        hotelService.saveReservation(reservation);

        System.out.println("Reservation added successfully.");
    }

    public void displayAllReservations() {

        hotelService.getAllReservations()
                .forEach(System.out::println);
    }

    public void displayReservationById(Long idReservation) {

        Reservation reservation =
                hotelService.getReservationById(idReservation);

        if (reservation != null) {

            System.out.println(reservation);

        } else {

            System.out.println("Reservation not found.");
        }
    }

    public void deleteReservation(Long idReservation) {

        hotelService.deleteReservation(idReservation);

        System.out.println("Reservation deleted successfully.");
    }
}