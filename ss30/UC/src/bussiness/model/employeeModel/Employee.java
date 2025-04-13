package bussiness.model.employeeModel;

import bussiness.model.Inputable;
import bussiness.model.LengthConstraint;
import validator.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Employee implements Inputable{
    private String employeeId;
    private String employeeName;
    private String email;
    private String phone;
    private Gender gender;
    private int salaryLevel;
    private double salary;
    private LocalDate birthDate;
    private String address;
    private EmployeeStatus employeeStatus;

    public Employee(){
    }

    public Employee(String employeeId, String employeeName, String email, String phone, Gender gender, int salaryLevel, double salary, LocalDate birthDate, String address, EmployeeStatus status){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.salaryLevel = salaryLevel;
        this.salary = salary;
        this.birthDate = birthDate;
        this.address = address;
        this.employeeStatus = status;
    }

    @Override
    public String toString(){
        return "ID: " + employeeId + ", Name: " + employeeName + ", Email: " + email + ", Phone: " + phone;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public Gender getGender(){
        return gender;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public int getSalaryLevel(){
        return salaryLevel;
    }

    public void setSalaryLevel(int salaryLevel){
        this.salaryLevel = salaryLevel;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public EmployeeStatus getStatus(){
        return employeeStatus;
    }

    public void setStatus(EmployeeStatus employeeStatus){
        this.employeeStatus = employeeStatus;
    }

    @Override
    public void inputData(Scanner input){
        this.employeeId = inputEmployeeId(input);
        this.employeeName = inputEmployeeName(input);
        this.email = inputEmployeeEmail(input);
        this.phone = inputEmployeePhone(input);
        this.gender = inputEmployeeGender(input);
        this.salaryLevel = inputEmployeeSalaryLevel(input);
        this.salary = inputEmployeeSalary(input);
        this.birthDate = inputEmployeeBirthDate(input);
        this.address = inputEmployeeAddress(input);
        this.employeeStatus = inputEmployeeStatus(input);
    }

    private String inputEmployeeId(Scanner input){
        return EmployeeValidator.validateEmployeeId(input, "Enter the employee ID: ", "^B\\d{4}$");
    }

    private String inputEmployeeName(Scanner input){
        return StringValidator.validate(input, "Enter the employee name: ", new LengthConstraint(15, 150));
    }

    private String inputEmployeeEmail(Scanner input){
        return EmployeeValidator.validateEmail(input, "Enter the email: ", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    private String inputEmployeePhone(Scanner input){
        return EmployeeValidator.validatePhoneNumber(input, "Enter the phone: ", "^0(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5|8|9]|9[0-9]|70|76|77|78|79|56|58|59|87)[0-9]{7}$");
    }

    private Gender inputEmployeeGender(Scanner input){
        return EmployeeValidator.validateGender(input, "Enter the gender: ");
    }

    private int inputEmployeeSalaryLevel(Scanner input){
        return IntegerValidator.validateInteger(input, "Enter the salary level: ", 0);
    }

    private double inputEmployeeSalary(Scanner input){
        return DoubleValidator.validateInteger(input, "Enter the salary: ", 0);
    }

    private LocalDate inputEmployeeBirthDate(Scanner input){
        return LocalDateValidator.validateDate(input, "Enter the employee birth date: ", "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|20[0-4][0-9]|2050)$");
    }

    private String inputEmployeeAddress(Scanner input){
        return StringValidator.validate(input, "Enter the employee address: ", new LengthConstraint(0, 255));
    }

    private EmployeeStatus inputEmployeeStatus(Scanner input){
        return EmployeeValidator.validateStatus(input, "Enter the status: ");
    }
}
