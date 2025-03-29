# Movie Ticket Reservation System

## Overview
This is a simple console-based Movie Ticket Reservation System built in Java. It allows users to add new bookings, retrieve saved bookings, and manage movie listings from a file.

## Features
- Add new movie bookings
- Retrieve saved bookings
- Load movie data from a CSV file
- Save and load booking information using serialization

## Class Descriptions

### 1. `Main`
- Handles user interaction via a menu-driven console interface.
- Provides options to add a new booking, retrieve a saved booking, or exit the system.

### 2. `Movie`
- Represents a movie with attributes like code, name, date, show time, total seats, available seats, ticket price, language, and genre.
- Allows seat reservations, reducing available seats upon booking.

### 3. `Booking`
- Represents a booking record that includes customer name, selected movie, reserved seats, and total price.
- Implements `Serializable` to enable saving and loading booking data.

### 4. `Files`
- Handles file operations, including loading movies from a CSV file and saving/loading bookings using object serialization.

## Setup Instructions
### Prerequisites
- Java Development Kit (JDK) installed
- A CSV file containing movie data (e.g., `movies.csv`)

### Running the Program
1. Compile the Java files:
   ```sh
   javac Main.java Movie.java Booking.java Files.java
   ```
2. Run the program:
   ```sh
   java Main
   ```

### CSV File Format for Movies
The CSV file should have the following structure:
```
code,name,date,time,totalSeats,availableSeats,ticketPrice,language,genre
M001,Avengers: Endgame,2023-06-15,18:00,100,100,10.50,English,Action
M002,Inception,2023-06-16,20:00,80,80,12.00,English,Sci-Fi
```

## Future Enhancements
- Implement user authentication.
- Add a graphical user interface (GUI).
- Introduce online payment integration.
- Enhance error handling and validation.

## License
This project is open-source and available for modification and distribution.

