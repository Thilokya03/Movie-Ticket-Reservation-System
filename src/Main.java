import java.util.*;


class BreakLoop extends Exception {
    public BreakLoop(){
        super();
    }
}

public class Main {
    static Vector<Movie> movies = new Vector<>();
    static Vector<String> booking = new Vector<>();
    static Scanner scanner = new Scanner(System.in);
    static Files file = new Files();

    /// #########################################################
    private static void newBill(){
        Movie mov = null;
        String customerName ;
        System.out.print("Enter your name : ");
        customerName = scanner.nextLine();
        while(true){
            System.out.println("There is available on following movies.");
            for(Movie movie: movies){
                System.out.printf("Movie code : %-5s | Name : %-20s | Date : %-10s | Show Time : %-10s | Language : %-10s | Genre : %-10s | Available Sets : %-4d | Ticket Price : Rs. %-5.2f\n",
                                    movie.code , movie.name , movie.date , movie.time, movie.lang , movie.genre , movie.avaSeats , movie.tickPrice);
            }
            System.out.println();
            System.out.print("Enter movie name that you want to reserve seats : ");
            String name = scanner.nextLine();
            System.out.print("Enter show time that you want to reserve seats : ");
            String time = scanner.nextLine();
            for(Movie movie : movies){
                if(movie.name.equals(name) && movie.time.equals(time)){
                    mov = movie;
                    System.out.println("You enter " + movie.name +" "+movie.date + " "+ movie.time+".");
                    break;
                }
            }
            if(mov != null){
                break;
            }
            System.out.println("Your input is wrong! Please enter correct input.");
        }
        int seat;
        while(true) try {
            System.out.print("How many seats you want to reseved :");
            seat = scanner.nextInt();
            scanner.nextLine();
            if (mov.reservedSeats(seat)) {
                System.out.println("Your seats are reseved.");
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Your input is invalid!!!\nPlease enter valid input.");
        }
        Booking book = new Booking(customerName,mov,seat);
        System.out.println("Your bill is "+ book.totalPrice + ".");
        int operation;
        System.out.println();
        boolean flag = true;
        while (flag){
            System.out.println("1 - Saved bocking\n2 - Complete booking\n3 - Delete booking");
            try{
                System.out.print("Enter your choice : ");
                operation = scanner.nextInt();
                scanner.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Your input is invalid!!!  Please enter valid input.");
                continue;
            }
            String conform;
            switch (operation){
                case 1 :
                    System.out.println(" You choose saved " + customerName + "'s booking.");
                    System.out.print("Do you conform it (Yes / No): ");
                    conform = scanner.nextLine();
                    if (conform.equals("yes")){
                        file.savedBooking(book , customerName);
                        booking.add(customerName);
                        flag = false;
                    }
                    else {
                        System.out.println("Failed Saved!!!");
                        break;
                    }
                    break;

                case 2 :
                    try {
                        System.out.println(" You choose complete " + customerName + "'s booking.");
                        System.out.println("Your bill is " + book.totalPrice + ".");
                        System.out.print("Enter your payment : ");
                        double payment = scanner.nextDouble();
                        scanner.nextLine();
                        if(payment < book.totalPrice){
                            throw new InputMismatchException();
                        }
                        System.out.println("Your remains : " + (payment - book.totalPrice));
                        System.out.println("Thank you!!!");
                        flag = false;
                        break;
                    }catch (InputMismatchException e){
                        System.out.println("Your input is invalid!!!\nPlease enter valid input.");
                        break;
                    }

                case 3 :
                    try {
                        System.out.println(" You choose deleting " + customerName + "'s booking.");
                        System.out.print("Do you conform it (Yes / No): ");
                        conform = scanner.nextLine();
                        if (conform.equals("yes")) {
                            flag = false;
                            break;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Your input is invalid!!!\nPlease enter valid input.");
                        break;
                    }
            }
        }
    }

    ///  ########################################################
    private static void savedBill() {

    }
    ///  ########################################################
    public static void main(String[] args) {
        file.LoadingMovie("Movie Reservation Dataset.csv",movies);
        System.out.println("*****     Welcome to Movie Ticket Reservation System     *****");
        System.out.println();
        System.out.println("""
                1 - Add new bill
                2 - Get saved bill
                3 - Exit the system
                """);

        while (true) {
            int operation;
            try {
                System.out.print("Enter your operation : ");
                operation = scanner.nextInt();
                scanner.nextLine();
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