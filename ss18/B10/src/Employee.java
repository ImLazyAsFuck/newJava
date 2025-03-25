import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Employee{
    private int id = 0;
    private String name;
    private float salary;

    public Employee(int salary, String name){
        this.salary = salary;
        this.name = name;
        ++this.id;
    }

    public Employee(){
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public float getSalary(){
        return salary;
    }

    public void inputData(Scanner input){
        ++this.id;
        System.out.print("Enter product name: ");
        this.name = input.nextLine();
        System.out.print("Enter product salary: ");
        this.salary = Float.parseFloat(input.nextLine());
    }

    public void updateData(Scanner input){
        System.out.print("Enter product name: ");
        this.name = input.nextLine();
        System.out.print("Enter product salary: ");
        this.salary = Float.parseFloat(input.nextLine());
    }

    public void displayData(){
        System.out.println("Customer ID: " + id);
        System.out.println("Customer Name: " + name);
        System.out.println("Customer Salary: " + salary);
    }
}
