import java.io.*;
import java.util.*;
public class BusTicketSystem{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String user = null, password = null;
        int to = 0, y = 1, z = 0, end = 0, r = 1;
        int available[] = new int[6];
        int ticketI[][] = new int[100][3];
        String ticketS[][] = new String[100][3];
        double ticketD[][] = new double[100][3];
        double pay[] = new double[20];

        for (int i = 1; i < 4; ) {
            System.out.print("Enter Username: ");
            user = sc.nextLine();
            System.out.print("Enter Password: ");
            password = sc.nextLine();

            if (user.equals("1") && password.equals("1")) {
                for (int x = 1; x == 1; ) {
                    System.out.println(" [1] Destination                ");
                    System.out.println(" [2] Passengers                 ");
                    System.out.println(" [3] Billing                    ");

                    String choice = null;

                    for (x = 1; x == 1; ) {
                        System.out.print("ENTER CHOICE: ");
                        choice = sc.nextLine();
                        x = 0;
                    }
                    if (choice.equals("1")) {
                        //the DESTINATION DETAILS//

                        System.out.println("                                       ");
                        System.out.println("**   DESTINATION   |  FARE  |  SEAT  **");
                        System.out.println("*                                      ");
                        System.out.println("** 1.)Jalandhar    | INR 30  |    " + available[1] + "   **");
                        System.out.println("** 2.)Ludhiana     | INR 90  |    " + available[2] + "   **");
                        System.out.println("** 3.)Chandigarh   | INR 250 |    " + available[3] + "   **");
                        System.out.println("** 4.)Ferozpur     | INR 150 |    " + available[4] + "   **");
                        System.out.println("** 5.)Phagwara     | INR 20  |    " + available[5] + "   **");
                        System.out.println("                                                      ");
                        System.out.println("\n");
                        x = 0;
                        i=5;
                    } else if (choice.equals("2")) {
                        int print = 1;


                        //display first the Destination Details//
                        System.out.println("                                       ");
                        System.out.println("**   DESTINATION   |  FARE  |  SEAT  **");
                        System.out.println("*                                      ");
                        System.out.println("** 1.)Jalandhar    | INR 30  |    " + available[1] + "   **");
                        System.out.println("** 2.)Ludhiana     | INR 90  |    " + available[2] + "   **");
                        System.out.println("** 3.)Chandigarh   | INR 250 |    " + available[3] + "   **");
                        System.out.println("** 4.)Ferozpur     | INR 150 |    " + available[4] + "   **");
                        System.out.println("** 5.)Phagwara     | INR 20  |    " + available[5] + "   **");
                        System.out.println("                                                      ");
                        System.out.println("\n");

                        if ((available[1] == 0) && (available[2] == 0) && (available[3] == 0) && (available[4] == 0) && (available[5] == 0)) {
                            System.out.println("Sorry, We don't  have available seats for all Destination!");
                            x = 0;
                        } else {
                            for (x = 1; x == 1; ) {
                                System.out.print("\nENTER PASSENGER'S NAME: ");
                                ticketS[z][0] = sc.nextLine();

                                x = 0;


                            }
                            //inputing of Destination//
                            //integers Only [1-5]//
                            for (x = 1; x == 1; ) {
                                System.out.print("ENTER DESTINATION [number]: ");
                                to = Integer.parseInt(sc.nextLine());

                                //if Inputed integers are "<1" or ">5", display error and go back to Inputing//
                                if (to < 1 || to > 5) {
                                    System.out.println("Invalid Input!");
                                    x = 1;
                                }
                                //if available seat is eqaul to "Zero", display error and go back to Inputing//
                                for (int d = 1; d <= 5; d++) {
                                    if (to == d) {
                                        if (available[to] == 0) {
                                            System.out.println("Sorry, We don't have available seat!");
                                            x = 1;
                                        }
                                        x = 0;
                                    }
                                }
                            }
                            //convert the integer to string//
                            String dest[] = {" ", "Jalandhar", "Ludhiana", "Chandigarh", "Ferozpur", "Phagwara"};
                            double fare[] = {0, 30, 90, 250, 150, 20};

                            //converted integer to string, transfer to storage array//
                            ticketS[z][1] = dest[to];
                            ticketD[z][0] = fare[to];

                            //inputing for Number of Passenger's//
                            for (x = 1; x == 1; ) {
                                System.out.print("HOW MANY PASSENGERS ARE YOU?: ");
                                ticketI[z][0] = Integer.parseInt(sc.nextLine());
                            }

                            //subtract the available seat by the the number inputed//
                            for (int p = 1; p <= 5; p++) {
                                if (to == p) {
                                    print = 1;
                                    available[to] = available[to] - ticketI[z][0];

                                    //if the subtracted available seat is "<0", display error//
                                    //add the inputed number to the subtracted seat, to back the original seat//
                                    //display the available seat and back to the inputing//
                                    if (available[to] < 0) {
                                        System.out.print("Sorry, We don't have seat available for " + ticketI[z][0] + " person\n");
                                        available[to] = available[to] + ticketI[z][0];
                                        System.out.print("We only have " + available[to] + " seat available\n");
                                        x = 1;
                                        print = 0;
                                    } else {
                                        x = 0;
                                    }
                                }
                            }

                        }
                        //print out of passengers details....
                        if (print == 1) {
                            System.out.println("\n***************************************");
                            System.out.println("**        PASSENGER'S DETAILS        **");
                            System.out.println("***************************************");
                            System.out.println("PASSENGER'S NAME: " + ticketS[z][0]);
                            System.out.println("PASSENGER'S DESTINATION : " + ticketS[z][1]);
                            System.out.println("FARE PRICE: Php " + ticketD[z][0]);
                            System.out.println("NO. OF PASSENGERS: " + ticketI[z][0]);
                            System.out.println("***************************************");
                            System.out.println("***************************************\n");
                            ticketS[z][2] = "0";
                            double discount = (ticketD[z][0] - (ticketD[z][0] * 0.2)) * ticketI[z][1];
                            ticketD[z][2] = ((ticketI[z][0] - ticketI[z][1]) * ticketD[z][0]) + discount;
                            x = 0;
                        }
                        z++;
                    } else if (choice.equals("3")) {


                        for (x = 1; x == 1; ) {

                            System.out.print("ENTER PASSENGER'S NAME: ");
                            String search = sc.nextLine();


                            int s = 1;
                            for (int b = 0; b < z; b++) {
                                if (search.equalsIgnoreCase(ticketS[b][0])) {
                                    System.out.println("***************************************");
                                    System.out.println("**        PASSENGER'S DETAILS        **");
                                    System.out.println("***************************************");
                                    System.out.println("PASSENGER'S NAME: " + ticketS[b][0]);
                                    System.out.println("PASSENGER'S DESTINATION : " + ticketS[b][1]);
                                    System.out.println("FARE PRICE: Php" + ticketD[b][0]);
                                    System.out.println("NO. OF PASSENGERS: " + ticketI[b][0]);
                                    System.out.println("***************************************");
                                    System.out.println("***************************************");
                                    s = 0;
                                    x = 0;

                                    if (ticketS[b][2].equals("x")) {
                                        System.out.println("Passenger's Already Paid!");
                                        x = 0;
                                    } else {
                                        ticketS[b][2] = "x";


                                        for (x = 1; x == 1; ) {
                                            System.out.println("\nPASSENGER'S TOTAL FARE: Php " + ticketD[b][2]);

                                        }
                                    }
                                }
                            }

                        }

                    } else {
                        System.out.println("Invalid Input!!!");
                        y = 1;
                    }

                }
            } else {
                System.out.println("\nInvalid user or password!\n");

                i++;
            }
        }
    }

    }



