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
 *contains various operations such as adding patients, 
 * deleting patients, editing patient information
 * adding doctors, deleting doctors, editing doctor information, 
 * and managing hospital departments.
 */
public class Operations {
        
    static ArrayList<Doctors> doctorList =new ArrayList<>();
    static ArrayList<Patients> patientList =new ArrayList<>();
    static ArrayList<String>departmentList =new ArrayList<>(); 
        private String Nameofhospital, PhoneNumber,address;

    Scanner input = new Scanner(System.in);

    public Operations() {
        
        this.Nameofhospital = null;
        this.PhoneNumber = null;
        this.address = null;

    }
    
    public Operations(String Nameofhospital, String PhoneNumber, String address) {
        
        this.Nameofhospital = Nameofhospital;
        this.PhoneNumber = PhoneNumber;
        this.address = address;
    }
    /**
     * to add a new patient by entering their name, phone number, ID, age, and gender. 
     * It performs validation to ensure that the ID is unique.
     */
    public void addPatient() {
        
        System.out.println("Enter the Patient name:");
        String Name = input.nextLine();

        System.out.println("Enter the Patient PhoneNumber:");
        String phoneNumber = input.nextLine();

        int ID;
        boolean isDuplicateId;
        do {
            do{
                System.out.println("Enter the Patient ID:");
                ID = input.nextInt();
                input.nextLine(); 
                if(ID <=0){
                    System.out.println("Invalid input. Please try again.");
                }
            }while(ID <=0);

            isDuplicateId = false;
            for (Patients patient : patientList) {
                if (patient.getID() == ID) {
                    isDuplicateId = true;
                    System.out.println("Patient ID already exists. Please enter a different ID.");
                    break;
                }
            }
        } while (isDuplicateId);
        int Age;
        do{
            System.out.println("Enter the Patient Age:");
            Age = input.nextInt();
            input.nextLine(); 
            if(Age<=0){
                System.out.println("Invalid input. Please try again.");
            }
        }while(Age <=0);

        char gender;
        do {
            System.out.println("Enter the Patient gender:");
            gender = input.nextLine().charAt(0);

            if (gender != 'f'&& gender != 'F'&& gender != 'm'&& gender != 'M') {
                System.out.println("Invalid input. Please try again.");
            }
        } while (gender != 'f'&& gender != 'F'&& gender != 'm'&& gender != 'M');
    



        Patients p = new Patients(Name, phoneNumber, ID, Age, gender);
        patientList.add(p);

        System.out.println("The patient has been added successfully.");
        
    }
    /**
     *  allows the user to delete a patient by entering their ID.
     * @throws java.io.IOException
     */
    public void deletePatient() throws IOException {
        System.out.println("Enter the ID of the patient to delete:");
        int patientID = input.nextInt();
        input.nextLine(); 

        for (int i = 0; i < patientList.size(); i++) {
            Patients p = patientList.get(i);
            if (p.getID() == patientID) {
                patientList.remove(i);
                System.out.println("The patient has been successfully deleted.");
                 writeDataToFile(); 

                return;
            }
        }
        System.out.println("No patient was found with the entered number.");
    }
    
    public void editPatient() throws IOException {
        System.out.println("\n Enter the ID of the patient to edit:");
        int patientID = input.nextInt();
        input.nextLine();

        for (int i = 0; i < patientList.size(); i++) {
            Patients p = patientList.get(i);
            if (p.getID() == patientID) {
                System.out.println("Enter the new name for the patient:");
                String newName = input.nextLine();

                System.out.println("Enter the new phone number for the patient:");
                String newPhoneNumber = input.nextLine();

                System.out.println("Enter the new age for the patient:");
                int newAge = input.nextInt();
                input.nextLine(); 

                System.out.println("Enter the new gender for the patient:");
                char newGender = input.nextLine().charAt(0);


                p.setName(newName);
                p.setPhoneNumber(newPhoneNumber);
                p.setAge(newAge);
                p.setGender(newGender);
                System.out.println("The patient was successfully modified.");
                writeDataToFile();

                return;
            }
        }

        System.out.println("No patient was found with the entered number.");
    }
    /**
     * prints the list of patients with their information.
     */
    public void printPatients() {
        System.out.println("List of Patients:");
        for (Patients p : patientList) {
            System.out.println("Name: " + p.getName());
            System.out.println("Phone Number: " + p.getPhoneNumber());
            System.out.println("ID: " + p.getID());
            System.out.println("Age: " + p.getAge());
            System.out.println("Gender: " + p.getGender());
            System.out.println();
        }
    }
    
    public void addDoctor() {

        System.out.println("Enter the doctor's name:");
        String name = input.nextLine();

        System.out.println("Enter the doctor's specialization:");
        String specialization = input.nextLine();
        int age ;
        do{
            System.out.println("Enter the doctor's age:");
            age = input.nextInt();
            input.nextLine(); 
            if(age<=0){
                System.out.println("Invalid input. Please try again.");
            }
        }while(age<=0);
        
        int doctorId;
        boolean isDuplicateId;
        do {
            System.out.println("Enter the doctor's ID:");
            doctorId = input.nextInt();
            input.nextLine(); 
            do{
                if(doctorId <=0){
                    System.out.println("Invalid input. Please try again.");
                    System.out.println("Enter the doctor's ID:");
                    doctorId = input.nextInt();
                    input.nextLine(); 
                }
            }while(doctorId <=0);

            isDuplicateId = false;
            for (Doctors doctor : doctorList) {
                if (doctor.getDoctorId() == doctorId) {
                    isDuplicateId = true;
                    System.out.println("Doctor ID already exists. Please enter a different ID.");
                    break;
                }
            }
        } while (isDuplicateId);
        char gender;
        do {
            System.out.println("Enter the doctor's gender:");
            gender = input.nextLine().charAt(0);

            if (gender != 'f'&& gender != 'F'&& gender != 'm'&& gender != 'M') {
                System.out.println("Invalid input. Please try again.");
            }
        } while (gender != 'f'&& gender != 'F'&& gender != 'm'&& gender != 'M');
        
        
        
        Doctors doctor = new Doctors(name, specialization, age, doctorId, gender);

        doctorList.add(doctor);
        System.out.println("Doctor added successfully.");
        
    }
    
    public void deleteDoctor()  throws IOException {

        System.out.println("Enter the ID of the doctor to delete:");
        int doctorId = input.nextInt();
        input.nextLine(); 

        for (int i = 0; i < doctorList.size(); i++) {
            Doctors doctor = doctorList.get(i);
            if (doctor.getDoctorId() == doctorId) {
                doctorList.remove(i);
                System.out.println("The doctor has been successfully deleted.");
                writeDataToFile(); 

                return;
            }
        }

        System.out.println("No doctor was found with the number entered.");
    }

    public void editDoctor() throws IOException {

        System.out.println("Enter the ID of the doctor to edit:");
        int doctorId = input.nextInt();
        input.nextLine(); 

        for (int i = 0; i < doctorList.size(); i++) {
            Doctors doctor = doctorList.get(i);
            if (doctor.getDoctorId() == doctorId) {
                System.out.println("Enter the new name for the doctor:");
                String newName = input.nextLine();

                System.out.println("Enter the new specialization for the doctor:");
                String newSpecialization = input.nextLine();

                System.out.println("Enter the new age for the doctor:");
                int newAge = input.nextInt();
                input.nextLine();

                System.out.println("Enter the new salary for the doctor:");
                double newSalary = input.nextDouble();
                input.nextLine(); 

                System.out.println("Enter the new gender for the doctor:");
                char newGender = input.nextLine().charAt(0);

                doctor.setName(newName);
                doctor.setSpecialization(newSpecialization);
                doctor.setAge(newAge);
                doctor.setSalary(newSalary);
                doctor.setGender(newGender);
                System.out.println("The doctor has been modified successfully.");
                writeDataToFile();
                return;
            }
        }

        System.out.println("No doctor was found with the number entered.");
    }
    


    public void printDoctors() {
        System.out.println("List of Doctors:");
        for (Doctors doctor : doctorList) {
            System.out.println("Name: " + doctor.getName());
            System.out.println("Specialization: " + doctor.getSpecialization());
            System.out.println("Age: " + doctor.getAge());
            System.out.println("Doctor ID: " + doctor.getDoctorId());
            System.out.println("Salary: " + doctor.getSalary());
            System.out.println("Gender: " + doctor.getGender());
            System.out.println();
        }
    }
    //طباعه كلهم
    public void printPatientsAndDoctors() {
            
        if (patientList.isEmpty())
        System.out.println("No patients available.\n");
        else
        printPatients();
        
    if (doctorList.isEmpty())
        System.out.println("No doctors available.");
    else
        printDoctors();
    if (patientList.isEmpty() && doctorList.isEmpty())
        System.out.println("No patients or doctors available.");
        
    }
    
        public void updateHospitalInfoFromUser() {
        
        System.out.print("Enter new name of hospital: ");
        String newName = input.nextLine();
        this.Nameofhospital = newName;
        
        System.out.print("Enter new phone number: ");
        String newPhoneNumber = input.nextLine();
        this.PhoneNumber = newPhoneNumber;
        
        System.out.print("Enter new address: ");
        String newAddress = input.nextLine();
        this.address = newAddress;
    }
    
    public void addDepartment(String department) {
        departmentList.add(department);
        System.out.println("Department added successfully.");
    }
    
    public void removeDepartment(String department)throws IOException {
        
        if(departmentList.remove(department)){
            System.out.println("Department removed successfully.");
            writeDataToFile(); // Update the file after removing the department

        } else {
            System.out.println("Department not found.");
        }
    }
    public void printDepartments() {
        
        System.out.println("List of departments: ");
        for (String department : departmentList) {
            System.out.println("the added Department is : "+ department);
        }
    }
      
     public void writeDataToFile() throws IOException {
        
        FileWriter fileWriter = new FileWriter("data.txt",true);
        PrintWriter outputFile = new PrintWriter(fileWriter);

        // Write data to the file
        for (int i = 0; i < doctorList.size(); i++) {
            outputFile.println(doctorList.get(i));
        }
        
        for (int i = 0; i < patientList.size(); i++) {
            outputFile.println(patientList.get(i));
        }
               for (int i = 0; i < departmentList.size(); i++) {
            outputFile.println("THE NEW DEPARTMENT : "+departmentList.get(i));
        }

        outputFile.close();
        //System.out.println("Data written to file successfully.");
    }
    

    public void readDataFromFile() throws IOException {
        
        File file = new File("data.txt");
        Scanner inputFile = new Scanner(file);


            // Read data from the file
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                // Process the line as per your requirement
                System.out.println(line);
            }

            inputFile.close();
            //System.out.println("Data read from file successfully.");
    }




    @Override
    public String toString() {
        return "Hospital \n" + 
                "{ Nameofhospital =" + Nameofhospital +
                ", PhoneNumber =" + PhoneNumber + 
                ", address =" + address + 
                '}';
    }    

    

}