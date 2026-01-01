/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmangementsystem;

/**
 *
 * @author reemk
 */public class Doctors {
    
    private String Name,Specialization;
    private int Age,DoctorId ;
    private double Salary = 80.0 ;
    private char Gender;

    public Doctors() {
        
        this.Name = " ";
        this.Specialization = " ";
        this.Age = 0;
        this.DoctorId = 0;
        this.Salary = 80.0;
        this.Gender = ' ';
    }

    public Doctors(String Name, String Specialization, int Age, int DoctorId, double Salary, char Gender) {
        this.Name = Name;
        this.Specialization = Specialization;
        this.Age = Age;
        this.DoctorId = DoctorId;
        this.Salary = Salary;
        this.Gender = Gender;
    }
        public Doctors(String Name, String Specialization, int Age, int DoctorId, char Gender) {//add doctor
        this.Name = Name;
        this.Specialization = Specialization;
        this.Age = Age;
        this.DoctorId = DoctorId;
        this.Gender = Gender;
    }

    
    public Doctors(String Name, String Specialization, int DoctorId) {//for booking
        this.Name = Name;
        this.Specialization = Specialization;
        this.DoctorId = DoctorId;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(int DoctorId) {
        this.DoctorId = DoctorId;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    @Override
    public String toString() {
        return "Doctors" +
                "{ Name=  " + Name + 
                ", Specialization  =" + Specialization + 
                ", Age  =" + Age + 
                ", DoctorId  =" +DoctorId + 
                ", Salary  =" + Salary + 
                ", Gender  =" + Gender + 
                '}';
    }
    
    
    
    
}

