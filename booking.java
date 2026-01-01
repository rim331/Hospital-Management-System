/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmangementsystem;

/**
 *
 * @author reemk
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

/**
 * Class that manages patient bookings in the hospital.
 */

    public class booking {
    private Doctors doctor;
    private Patients patient ;

    private static ArrayList<booking> bookingList = new ArrayList<>(); // List to store all bookings

    Scanner input = new Scanner(System.in);

    public booking() {

    }

    public booking(Doctors doctor, Patients patient) {
        this.doctor = doctor;
        this.patient = patient;
        
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    /**
     * Creates a new booking by taking doctor and patient information from the user.
     * Adds the new booking to the bookingList.
     */
    public void makeBooking() {
        int ID,doctorId;
        System.out.println("\n ----------------------Booking details:------------------------------");

        do{
            System.out.println("Enter the doctor's ID:");
            doctorId = input.nextInt();
            input.nextLine();

            System.out.println("Enter the Patient ID:");
            ID = input.nextInt();
            input.nextLine();
            if (doctorId <= 0 || ID <= 0) {
            System.out.println("Invalid input. IDs cannot be negative. Please try again.");
            }
        }while(doctorId <= 0 || ID <= 0);
        
        for (booking existingBooking : bookingList) {
            // Get the existing doctor and patient from the booking
            Doctors existingDoctor = existingBooking.getDoctor();
            Patients existingPatient = existingBooking.getPatient();
            // Check if the existing doctor and patient match the given doctorId and ID
            if(existingDoctor != null&&existingPatient != null){
                if (existingDoctor.getDoctorId() == doctorId &&
                        existingPatient.getID() == ID) {
                    System.out.println("There is a previous booking for this patient with the same doctor.");
                    return;
                }
            }
        }
    
        System.out.println("Enter the doctor's name:");
        String doctorName = input.nextLine();

        System.out.println("Enter the doctor's specialization:");
        String specialization = input.nextLine();

        System.out.println("Enter the patient's name:");
        String patientName = input.nextLine();
       
        // Create doctor and patient objects
        Doctors doctor = new Doctors(doctorName, specialization,doctorId);
        Patients patient = new Patients(patientName,ID);

        // Create a booking object
        booking newBooking = new booking(doctor, patient);

        // Add the booking to the bookingList
        bookingList.add(newBooking);

        System.out.println("Booking successfully made.");

    }
      /**
     * Updates the booking information associated with a specific doctor.
     * Updates the matching booking information and writes the updated data to the file.
     */
    
    public void updateBooking() throws IOException {
        
        System.out.println("Enter the ID of the doctor for the booking to update:");
        int doctorId = input.nextInt();
        input.nextLine(); // Consume the newline character

        for (booking booking : bookingList) {
            Doctors doctor = booking.getDoctor();
            if (doctor != null && doctor.getDoctorId() == doctorId) {
                System.out.println("Enter the new doctor's name:");
                String doctorName = input.nextLine();

                System.out.println("Enter the new doctor's specialization:");
                String specialization = input.nextLine();

                System.out.println("Enter the new patient's name:");
                String patientName = input.nextLine();

                // Update the doctor and patient information
                doctor.setName(doctorName);
                doctor.setSpecialization(specialization);
                booking.getPatient().setName(patientName);

                System.out.println("Booking successfully updated.");
                writeDataToFile();
                return;
            }
        }
        System.out.println("No booking was found with the doctor ID entered.");
    }

    
     /**
     * Deletes the booking associated with a specific doctor from the bookingList.
     * @throws java.io.IOException
     */
     
    public void deleteBooking() throws IOException{
        System.out.println("Enter the ID of the doctor for the booking to delete:");
        int doctorId = input.nextInt();
        input.nextLine(); // Consume the newline character

        for (int i = 0; i < bookingList.size(); i++) {
            booking booking = bookingList.get(i);
            Doctors doctor = booking.getDoctor();
            if (doctor != null && doctor.getDoctorId() == doctorId) {
                bookingList.remove(i);
                System.out.println("The booking has been successfully deleted.");
                writeDataToFile(); // Update the file after removing the department

                return;
            }
        }
        System.out.println("No booking was found with the doctor ID entered.");
    }

      // Check if there is a booking
    public static boolean hasBooking() {
         return !bookingList.isEmpty();
    }


     public static void printAvailableBookings() {
         if (hasBooking()) {
             System.out.println("Available Bookings:");
             for (booking book : bookingList) {
                 System.out.println(book);
             }
        } else {
             System.out.println("No bookings available.");
        }
     }
     /**
     * Writes the booking data to the "booking_data.txt" file.
     * Opens the output file and writes the stored booking data in the bookingList.
     * @throws java.io.IOException
     */
     public void writeDataToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("booking_data.txt",true);
        PrintWriter outputFile = new PrintWriter(fileWriter);

        // كتابة بيانات الحجوزات إلى الملف
        for (int i = 0; i < bookingList.size(); i++) {
            outputFile.println(bookingList.get(i));
        }

        outputFile.close();
//        System.out.println("Data written to file successfully.");
    }

    /**
     * Reads the booking data from the "booking_data.txt" file and prints it.
     * @throws java.io.IOException
     */
    public void readDataFromFile() throws IOException {
        File file = new File("booking_data.txt");
        Scanner inputFile = new Scanner(file);

            System.out.println("Booking data:");

            // قراءة البيانات من الملف وطباعتها
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                System.out.println(line);
            }

            inputFile.close();
        // System.out.println("Data read from file successfully.");
    }

     @Override
    public String toString(){
         return "Booking \n"+
                 "{ Dr. = " + doctor.getName() +
                 " THE Salary ="  +doctor.getSalary()+
                 ", patient Name =" + patient.getName() +
                 '}';
    }

}

