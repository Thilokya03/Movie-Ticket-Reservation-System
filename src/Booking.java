import java.io.*;

public class Booking implements Serializable {
    String customer;
    Movie movie;
    int seats;
    double totalPrice;

    public Booking(String name, Movie movie, int seats) {
        this.customer = name;
        this.movie = movie;
        this.seats = seats;
        this.totalPrice = movie.tickPrice * seats;
    }

}
