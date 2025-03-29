import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Files {
    public void LoadingMovie(String filePath, List<Movie> movies){
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(file);
            String line = null;
            reader.readLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while((line = reader.readLine()) != null){
                String[] split = line.split(",");
                Date date = dateFormat.parse(split[2]);
                if(split.length != 9){
                    throw new IndexOutOfBoundsException();
                }
                Movie movie = new Movie(split[0],split[1],date,split[3],Integer.parseInt(split[4]),Integer.parseInt(split[5]),Double.parseDouble(split[6]),split[7],split[8]);
                movies.add(movie);
            }
            System.out.println("All movies are added...");
        } catch (FileNotFoundException e){
            System.out.println("File not found!!!");
        } catch (IOException e) {
            System.out.println("Can not read " + filePath + ".");;
        } catch (ParseException | IndexOutOfBoundsException e) {
            System.out.println("Your csv file has an error!!!");
        }
    }
    public void savedBooking(String filePath) {
        try {
            FileOutputStream fileStream = new FileOutputStream(filePath);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(this);
            os.close();
            System.out.println("Booking saved successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Cannot save booking: " + e.getMessage());
        }
    }

    public static Booking loadBooking(String filePath) {
        try {
            FileInputStream fileStream = new FileInputStream(filePath);
            ObjectInputStream is = new ObjectInputStream(fileStream);
            Booking loadedBooking = (Booking) is.readObject();
            is.close();
            System.out.println("Booking loaded successfully: " + filePath);
            return loadedBooking;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load booking: " + e.getMessage());
            return null;
        }
    }
}
