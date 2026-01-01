package hospitalmangementsystem;

import hospitalmangementsystem.Operations;
import hospitalmangementsystem.booking;
import java.util.Scanner;
import java.io.IOException;

import java.util.Scanner;
import java.io.IOException;

/**
 *  program for managing a hospital
 */
public class HospitalMangementSystem {

    public static void main(String[] args)throws IOException {
        // Create a hospital object        
            Scanner input = new Scanner(System.in);
            Operations hospital = new Operations("S R Hospital","0555123450","Jeddah");
            Operations Op =new Operations();
            booking book =new booking();

            int choice = 0;
            int c=0 ;
            String departmentName;
            System.out.println("--------------------------------------------WELCOME TO THE HOSPITAL-------------------------------------------.");
            while (choice != 5){
                printManagementMenu();
                choice = input.nextInt();
                input.nextLine(); // consume the newline character
                switch (choice) {
                    /**
                     * hospital administration, where sub-menu options are provided for adding, deleting, 
                     * and editing patients and doctors, as well as printing patient and doctor data.
                     */
                    case 1:
                        System.out.println("---------------------------------------WELCOME TO THE ADMIN MENUE-------------------------------------------.");
                            while( c != 8){
                                    printAdminMenu();
                                    c = input.nextInt();
                                    switch (c) {
                                        case 1://اضافة مريض
                                            Op.addPatient();
                                        break;

                                        case 2://حذف مريض
                                            Op.deletePatient();

                                        break;
                                        case 3://تعديل مريض
                                            Op.editPatient();
                                        break;

                                        case 4://اضافة دكتور
                                            Op.addDoctor();
                                        break;
                                        case 5://حذف دكتور
                                            Op.deleteDoctor();
                                        break;

                                        case 6://تعديل دكتور
                                            Op.editDoctor();
                                        break;
                                        case 7://طباعة البيانات
                                            Op.printPatientsAndDoctors();

                                        break;
                                        case 8://العودة للقائمة
                                            main(args);
                                            break;

                                        default:
                                            System.out.println("Please choose a valid option.");
                                            break;
                                    }
                        }//end while الداخلية  للاداره
                        break;//نهايه الادارة 
                        /**
                         * managing bookings, where sub menu options are provided for adding,
                         * deleting, updating, and printing bookings.
                         */
                    case 2://الحجز
                        System.out.println("---------------------------------------WELCOME TO THE BOOKING MENUE-------------------------------------------.");

                        // قم بتنفيذ الإجراءات المتعلقة بإدارةالحجز  هنا
                            while( c != 5){
                                printbooking();
                                c = input.nextInt();
                                switch (c) {
                                    case 1://اضافة حجز
                                        book.makeBooking();
                                        break;

                                    case 2://حذف حجز
                                        book.deleteBooking();
                                        break;
                                    case 3://تعديل حجز
                                        book.updateBooking();
                                        break;
                                    case 4://طباعة الحجوزات
                                        book.printAvailableBookings();
                                        break;
                                    case 5://العودة للقائمة
                                        main(args);
                                        break;
                                    default:
                                        System.out.println("Please choose a valid option.");
                                        break;
                                }
                            }
                        break;//نهايه الحجز
                        
                        // قم بتنفيذ الإجراءات المتعلقة بإدارة المستشفى هنا
                    /**
                     * for managing the hospital itself, including adding and deleting departments,
                     * printing department information, printing hospital information, 
                     * and updating hospital information.
                     * 
                     */
                    case 3:
                        System.out.println("---------------------------------------WELCOME TO THE HOSPITAL MENUE-------------------------------------------.");
                            while( c != 6){
                                printhospital();                        
                                c = input.nextInt();
                                input.nextLine(); 
                                switch (c) {
                                    case 1://اضافة قسم   
                                          // إضافة قسم
                                        System.out.print("Enter the department name:");
                                        departmentName = input.nextLine();
                                        Op.addDepartment(departmentName);

                                        break;
                                    case 2://حذف قسم 
                                        System.out.print("Enter the name of the department to delete:");
                                        departmentName = input.nextLine();
                                        Op.removeDepartment(departmentName);
                                        break;
                                    case 3://  طباعة المعلومات الاقسام
                                        Op.printDepartments();
                                        break;
                                    case 4://  طباعة المعلومات المستشفى
                                            System.out.println(hospital.toString());                                            
                                        break;
                                    case 5://تحديث معلومات المستشفى
                                        hospital.updateHospitalInfoFromUser();
                                        break;
                                    case 6://العودة للقائمة
                                        main(args);
                                        break;

                                    default:
                                        System.out.println("Please choose a valid option.");
                                        break;
                                }
                            }//end while المستشفى 
                        break;//نهايه المستشفى 
                    /**
                     * for printing the lists of doctors, patients, departments, 
                     * and bookings from a file.
                     */
                    case 4:
                        System.out.println("---------------------------------------WELCOME TO THE PRINT THE FILE-------------------------------------------.");

                        System.out.println("The List of Doctors and Patients and Department");
                        Op.writeDataToFile();
                        Op.readDataFromFile();
                        System.out.println("The List of booking ");
                        book.writeDataToFile();
                        book.readDataFromFile();
                       
                        break;
                        /**
                         *  for exiting the program.
                         */
                    case 5:
                        System.out.println("------------------------------------Logged out successfully.------------------------------------");
                        System.out.println("--------------------------------------------GOOD BYE-------------------------------------------.");

                        break;

                    default:
                        System.out.println("Please choose a valid option.");
                        break;
                }//end switch choice
            }//end while


        }//end main
    
        public static void printManagementMenu() {
            System.out.println("enter your choice:");
            System.out.println("1. Manage");
            System.out.println("2. booking");
            System.out.println("3. hospital");
            System.out.println("4. print the List from File");
            System.out.println("5. exsit");
            System.out.print("Choose option number: ");

        }//end print
        
        public static void printAdminMenu() {
            System.out.println("Patient and Doctor Management:");
            System.out.println("1. Add Patient");
            System.out.println("2. Delete Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Add Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Update Doctor");
            System.out.println("7. Print patient and doctor data");
            System.out.println("8. Menu");
            System.out.print("Choose option number:");
    }//end printAdminMenu
        public static void printbooking() {
                        
            System.out.println("Booking...");
            System.out.println("1. Add Booking");
            System.out.println("2. Delete Booking");
            System.out.println("3. Update Booking");
            System.out.println("4. Printing the existing bookings ");
            System.out.println("5. Menu");
            System.out.print("Choose option number: ");

        }//end printbooking  
        public static void printhospital() {

            System.out.println("Hospital...");
            System.out.println("1. Add Department");
            System.out.println("2. Delete Department");
            System.out.println("3. Print Departments");
            System.out.println("4. Print Information of Hospital");
            System.out.println("5. Update Information of Hospital");
            System.out.println("6. Menu");
            System.out.print("Choose option number: ");
        }//end printhospital

}//end class
