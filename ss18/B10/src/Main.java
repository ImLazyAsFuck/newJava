import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Menu");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Calculate Total Salary");
            System.out.println("4. Calculate Average Salary");
            System.out.println("5. Search Highest Salary Employee");
            System.out.println("6. Search Lowest Salary Employee");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch(choice){
                case 1:
                    EmployeeManagement.addEmployee(input);
                    break;
                case 2:
                    EmployeeManagement.displayEmployee();
                    break;
                case 3:
                    EmployeeManagement.calculateTotalSalary();
                    break;
                case 4:
                    EmployeeManagement.calculateAverageSalary();
                    break;
                case 5:
                    EmployeeManagement.searchHighestSalaryEmployee();
                    break;
                case 6:
                    EmployeeManagement.searchLowestSalaryEmployee();
                    break;
                case 0:
                    System.out.println("Goodbye");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}