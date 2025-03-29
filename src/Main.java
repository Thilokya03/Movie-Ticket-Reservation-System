import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Vector<Movie> movies = new Vector<>();
    static Scanner scanner = new Scanner(System.in);

    /// #########################################################
    private static void newBill(){

    }

    ///  ########################################################
    private static void savedBill() {
    }
    ///  ########################################################
    public static void main(String[] args) {
        System.out.println("*****     Welcome to Movie Ticket Reservation System     *****");
        System.out.println();
        System.out.println("1 - Add new bill\n" +
                           "2 - Get saved bill\n" +
                           "3 - Exit the system\n");

        while (true) {
            int operation;
            try {
                operation = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Your input is invalid!!!  Please enter valid input.");
                continue;
            }
            switch (operation){
                case 1 :
                    newBill();
                    break;

                case 2 :
                    savedBill();
                    break;
                case 3:
                    System.out.println("\nThank you !!!");
                    System.exit(0);

            }
        }
    }
}