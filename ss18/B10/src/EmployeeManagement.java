import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManagement{
    public static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

    public static void addEmployee(Scanner input){
        Employee newEmployee = new Employee();
        newEmployee.inputData(input);
        employees.put(newEmployee.getId(), newEmployee);
        System.out.println("Employee added successfully");
    }

    public static void displayEmployee(){
        for(Employee employee : employees.values()){
            employee.displayData();
        }
    }

    public static void calculateTotalSalary(){
        float totalSalary = 0;
        for(Employee employee : employees.values()){
            totalSalary += employee.getSalary();
        }
        System.out.println("Total salary: " + totalSalary);
    }

    public static void calculateAverageSalary(){
        float totalSalary = 0;
        for(Employee employee : employees.values()){
            totalSalary += employee.getSalary();
        }
        float averageSalary = totalSalary / employees.size();
        System.out.println("Average salary: " + averageSalary);
    }

    public static void searchHighestSalaryEmployee(){
        if(employees.isEmpty()){
            System.out.println("No employee found");
            return;
        }

        float highestSalary = 0;
        int foundId = -1;

        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            int id = entry.getKey();
            Employee emp = entry.getValue();

            if (emp.getSalary() > highestSalary) {
                highestSalary = emp.getSalary();
                foundId = id;
            }
        }

        System.out.println("Employee with highest salary: ID " + foundId + ", Salary: " + highestSalary);
    }

    public static void searchLowestSalaryEmployee(){
        if(employees.isEmpty()){
            System.out.println("No employee found");
            return;
        }

        float lowestSalary = 0;
        int foundId = -1;

        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            int id = entry.getKey();
            Employee emp = entry.getValue();
            if (emp.getSalary() < lowestSalary) {
                lowestSalary = emp.getSalary();
            }
        }

        System.out.println("Employee with lowest salary: ID " + foundId + ", Salary: " + lowestSalary);
    }
}
