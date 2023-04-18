import java.util.Scanner;

public class BusTicketBookingSystem {
    private static Bus[] buses = {
            new Bus(1, "Phagwara to Jalandhar", "10:00 AM", 30),
            new Bus(2, "Ludhiana to Chandigarh", "11:30 AM", 250),
            new Bus(3, "Jalandhar to Ferozepur", "1:00 PM", 150),
            new Bus(4, "Jalandhar to Delhi", "2:30 PM", 700),
            new Bus(5, "Phagwara to Bhatinda", "4:00 PM", 200)

    };

    private static void displayBuses() {
        System.out.println("Available buses:");
        for (Bus bus : buses) {
            System.out.println(bus.toString());
        }
    }

    private static void bookTicket(int busId, String name, String email, String phone) {
        Bus bus = null;
        for (Bus b : buses) {
            if (b.getId() == busId) {
                bus = b;
                break;
            }
        }
        if (bus == null) {
            System.out.println("Invalid bus id.");
            return;
        }
        System.out.println("Booking details:");
        System.out.println("Bus: " + bus.getRoute() + " at " + bus.getTime());
        System.out.println("Passenger: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Fare: " + bus.getFare() + " Rs");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();


        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful!");
            displayBuses();
            System.out.print("Enter the bus id you want to book: ");
            int busId = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Enter your phone number: ");
            String phone = scanner.nextLine();
            bookTicket(busId, name, email, phone);
        } else {
            System.out.println("Invalid username or password.");
        }


        scanner.close();
    }
}

class Bus {
    private int id;
    private String route;
    private String time;
    private int fare;

    public Bus(int id, String route, String time, int fare) {
        this.id = id;
        this.route = route;
        this.time = time;
        this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public String getRoute() {
        return route;
    }

    public String getTime() {
        return time;
    }

    public int getFare() {
        return fare;
    }

    public String toString() {
        return id + ". " + route + " at " + time + " (" + fare + " Rs)";}}
