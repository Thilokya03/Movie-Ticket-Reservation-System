import java.util.Date;

public class Movie {
    String code, name, time, lang, genre;
    String date;
    int avaSeats , totSeats;
    double tickPrice;

    public Movie(String movieCode,String movieName, String date, String showTime, int totalSeats ,int availableSeats, double ticketPrice, String language, String genre){
        this.code = movieCode;
        this.name = movieName;
        this.date = date;
        this.time = showTime;
        this.totSeats = totalSeats;
        this.avaSeats = availableSeats;
        this.tickPrice= ticketPrice;
        this.lang = language;
        this.genre = genre;
    }

    public boolean reservedSeats(int seats){
        if(this.avaSeats >= seats){
            this.avaSeats-= seats;
            return true;
        }
        else{
            System.out.println("Seats are not enough!!!");
            return false;
        }
    }
}
