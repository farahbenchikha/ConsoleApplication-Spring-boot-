package tn.esprit.consoleapplication;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.esprit.consoleapplication.controllers.HotelController;
import tn.esprit.consoleapplication.entities.Client;
import tn.esprit.consoleapplication.entities.Room;
import tn.esprit.consoleapplication.entities.RoomStatus;
import tn.esprit.consoleapplication.services.interfaces.HotelService;

import java.util.Scanner;

@SpringBootApplication
@AllArgsConstructor

public class ConsoleApplication implements CommandLineRunner {

    private final HotelController hotelController;

    private final HotelService hotelService;

    public static void main(String[] args) {

        SpringApplication.run(ConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n===== HOTEL MANAGEMENT =====");

            System.out.println("1. Add Client");
            System.out.println("2. Show All Clients");
            System.out.println("3. Delete Client");

            System.out.println("4. Add Room");
            System.out.println("5. Show All Rooms");
            System.out.println("6. Delete Room");

            System.out.println("0. Exit");

            System.out.print("Choose option : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ================= CLIENT =================

                case 1:

                    Client client = new Client();

                    System.out.print("First Name : ");
                    client.setFirstNameClient(scanner.nextLine());

                    System.out.print("Last Name : ");
                    client.setLastNameClient(scanner.nextLine());

                    String email;

                    while (true) {

                        System.out.print("Email : ");
                        email = scanner.nextLine();

                        if(hotelService.emailExists(email)) {

                            System.out.println("Email already exists !");

                        } else {

                            break;
                        }
                    }

                    client.setEmailClient(email);

                    System.out.print("Phone : ");
                    client.setPhoneClient(scanner.nextLine());

                    hotelController.addClient(client);

                    break;

                case 2:

                    hotelController.displayAllClients();

                    break;

                case 3:

                    System.out.print("Client ID : ");

                    Long idClient = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Are you sure ? (y/n) : ");

                    String confirmClient = scanner.nextLine();

                    if(confirmClient.equalsIgnoreCase("y")) {

                        hotelController.deleteClient(idClient);

                    } else {

                        System.out.println("Deletion cancelled.");
                    }

                    break;

                // ================= ROOM =================

                case 4:

                    Room room = new Room();

                    String roomNumber;

                    while (true) {

                        System.out.print("Room Number : ");
                        roomNumber = scanner.nextLine();

                        if(roomNumber.isBlank()) {

                            System.out.println("Room number cannot be empty !");

                        } else {

                            break;
                        }
                    }

                    room.setRoomNumber(roomNumber);

                    System.out.print("Floor : ");
                    room.setFloorRoom(scanner.nextInt());

                    System.out.print("Capacity : ");
                    room.setCapacityRoom(scanner.nextInt());

                    System.out.print("Price Per Night : ");
                    room.setPricePerNightRoom(scanner.nextDouble());

                    scanner.nextLine();

                    room.setStatusRoom(RoomStatus.AVAILABLE);

                    hotelController.addRoom(room);

                    System.out.println("Room added successfully.");

                    break;

                case 5:

                    hotelController.displayAllRooms();

                    break;

                case 6:

                    System.out.print("Room ID : ");

                    Long idRoom = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Are you sure ? (y/n) : ");

                    String confirmRoom = scanner.nextLine();

                    if(confirmRoom.equalsIgnoreCase("y")) {

                        hotelController.deleteRoom(idRoom);

                    } else {

                        System.out.println("Deletion cancelled.");
                    }

                    break;

                case 0:

                    System.out.println("Application closed.");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}