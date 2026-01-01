/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmangementsystem;

/**
 *
 * @author reemk
 */
public class Patients {
    
    private String Name ,PhoneNumber ;
    private int ID, Age ;
    private char Gender ;

    public Patients() {
        this.Name = null;
        this.PhoneNumber = null;
        this.ID = 0;
        this.Age = 0;
        this.Gender = ' ';
    }
        

    public Patients(String Name, String PhoneNumber, int ID, int Age, char Gender) {
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.ID = ID;
        this.Age = Age;
        this.Gender = Gender;
    }



    public Patients(String Name, int ID) {//for booking
        this.Name = Name;
        this.ID = ID;
    }
     
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    @Override
    public String toString() {
        return "Patients" + 
                " { Name =" + Name + 
                ", PhoneNumber =" + PhoneNumber + 
                ", ID =" + ID + 
                ", Age =" + Age + 
                ", Gender =" + Gender +
                '}';
    }
    
    
    
}

    

