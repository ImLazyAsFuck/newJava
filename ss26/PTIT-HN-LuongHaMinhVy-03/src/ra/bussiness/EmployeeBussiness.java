package ra.bussiness;

import ra.entity.Employee;
import ra.entity.IntegerLength;
import ra.validate.*;

import java.util.*;

public class EmployeeBussiness{
    public static int MAX_EMPLOYEE = 100;
    public static List<Employee> employees = new ArrayList<>();

    public static void displayEmployees(){
        if(employees.isEmpty()){
            System.out.println("Employee list is empty");
            return;
        }
        System.out.println("Employee list:");
        employees.forEach(Employee::displayData);
    }

    public static void addEmployee(Scanner sc){
        if(employees.size() == MAX_EMPLOYEE){
            System.out.println("Employee list is full");
            return;
        }
        int amounts = AmountStudentValidator.amountStudentaValidator(sc, "Enter amount of employee would you like to add: ", new IntegerLength(0, MAX_EMPLOYEE - employees.size()));
        for(int i = 0; i < amounts; i++){
            Employee newEmployee = new Employee();
            newEmployee.inputData(sc);
            employees.add(newEmployee);
            System.out.println();
        }
        System.out.println("Employee added successfully");
    }

    public static void updateEmployee(Scanner sc){
        if(employees.isEmpty()){
            System.out.println("Employee list is empty");
            return;
        }
        System.out.println("Employee list:");
        employees.forEach(e -> System.out.println("ID: " + e.getEmployeeId() + "| Name: " + e.getEmployeeName()));
        System.out.println("Enter Employee ID: ");
        String id = sc.nextLine();
        int found = -1;
        for(int i = 0; i < employees.size(); i++){
            if(id.equals(employees.get(i).getEmployeeId())){
                found = i;
            }
        }
        if(found == -1){
            System.out.println("Employee not found");
            return;
        }
        Employee foundEmployee = employees.get(found);
        while(true){
            updateMenu();
            int choice;
            try{
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Invalid choice");
                continue;
            }
            switch(choice){
                case 0:
                    System.out.println("Returning to the main menu");
                    System.exit(0);
                case 1:
                    foundEmployee.setEmployeeName(StringValidator.validateString(sc, "Enter new employee name: "));
                    break;
                case 2:
                    foundEmployee.setBirthday(EmployeeValidator.validateEmmployeeString(sc, "Enter new birthday: ", "\\d{4}-\\d{2}-\\d{2}"));
                    break;
                case 3:
                    foundEmployee.setPhoneNumber(EmployeeValidator.validateEmmployeeString(sc, "Enter new phone number: ", "(84|0[35789])[0-9]{7})"));
                    break;
                case 4:
                    foundEmployee.setSex(BooleanValidator.validateBoolean(sc, "Enter new sex: "));
                    break;
                case 5:
                    foundEmployee.setCoefficient(FloatValidator.validateFloat(sc, "Enter new coefficient"));
                    break;
                case 6:
                    foundEmployee.setAllowanceSalary(IntegerValidator.validateInt(sc, "Enter new allowance salary"));
                    break;
                case 7:
                    foundEmployee.setDepartment(StringValidator.validateString(sc, "Enter new department: "));
                    break;
                case 8:
                    foundEmployee.setStatus(ByteValidator.byteValidator(sc, "Enter new status (1, 2 or 3): "));
                    break;
            }
        }
    }

    public static void updateMenu(){
        System.out.println("Menu");
        System.out.println("1. Employee Name");
        System.out.println("2. Employee Birthday");
        System.out.println("3. Employee Phone Number");
        System.out.println("4. Employee Sex");
        System.out.println("5. Employee Coefficient");
        System.out.println("6. Employee Allowance Salary");
        System.out.println("7. Employee Department");
        System.out.println("8. Employee Status");
        System.out.println("0. Exit");
    }

    public static void deleteEmployee(Scanner sc){
        if(employees.isEmpty()){
            System.out.println("Employee list is empty");
            return;
        }
        System.out.print("Enter employee ID: ");
        String id = sc.nextLine();
        int found = -1;
        for(int i = 0; i < employees.size(); i++){
            if(id.equals(employees.get(i).getEmployeeId())){
                found = i;
            }
        }
        if(found == -1){
            System.out.println("Employee not found");
            return;
        }
        Employee foundEmployee = employees.get(found);
        while(true){
            System.out.print("Do you want to delete the employee (y/n)? : ");
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("y")){
                employees.remove(foundEmployee);
            }else if(choice.equalsIgnoreCase("n")){
                System.out.println("Canceled deletion");
                return;
            }
            System.out.println("Invalid choice please choose Y/N");
        }
    }

    public static void seachEmployee(Scanner sc){
        if(employees.isEmpty()){
            System.out.println("Employee list is empty");
            return;
        }
        while(true){
            searchMenu();
            int choice;
            int found = -1;
            try{
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(sc.nextLine());
            }catch(NullPointerException e){
                System.out.println("Please enter number");
                continue;
            }
            switch(choice){
                case 0:
                    System.out.println("Returning to the main menu");
                    System.exit(0);
                case 1:
                    System.out.println("Enter Employee Name: ");
                    String employeeName = sc.nextLine();
                    for(int i = 0; i < employees.size(); i++){
                        if(employeeName.equals(employees.get(i).getEmployeeName())){
                            found = i;
                        }
                    }
                    if(found == -1){
                        System.out.println("Employee not found");
                        break;
                    }
                    Employee foundEmployee = employees.get(found);
                    foundEmployee.displayData();
                    break;
                case 2:
                    Set<String> departments = new HashSet<>();
                    for(Employee employee : employees){
                        departments.add(employee.getDepartment());
                    }
                    for(String department : departments){
                        System.out.println(department);
                    }
                    System.out.println("Enter Employee Department: ");
                    String departmentName = sc.nextLine();
                    for(int i = 0; i < employees.size(); i++){
                        if(departmentName.equals(employees.get(i).getDepartment())){
                            found = i;
                        }
                    }
                    if(found == -1){
                        System.out.println("Employee not found");
                        break;
                    }
                    employees.get(found).displayData();
                    break;
                case 3:
                    if(employees.isEmpty()){
                        System.out.println("Employee list is empty");
                        return;
                    }
                    int minPrice;
                    int maxPrice;
                    Set<Employee> foundEmployees = new HashSet<>();
                    while(true){
                        try{
                            System.out.print("Enter minimum price: ");
                            minPrice = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter maximum price: ");
                            maxPrice = Integer.parseInt(sc.nextLine());
                            break;
                        }catch(NumberFormatException e){
                            System.out.println("Please enter number");
                        }
                    }
                    for(Employee employee : employees){
                        if(employee.getCoefficient() >= minPrice && employee.getCoefficient() <= maxPrice){
                            foundEmployees.add(employee);
                        }
                    }
                    if(foundEmployees.isEmpty()){
                        System.out.println("Employee not found");
                    }
                    foundEmployees.forEach(Employee::displayData);
                    break;
                default:
                    System.out.println("Please choose a valid choice");
            }
        }
    }

    public static void sortEmployees(Scanner sc){
        if(employees.isEmpty()){
            System.out.println("Employee list is empty");
            return;
        }
        while(true){
            System.out.println("Sort Menu");
            System.out.println("1. Employee Name");
            System.out.println("2. Employee totalSalary");
            int choice;
            while(true){
                try{
                    System.out.print("Enter choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                }catch(NumberFormatException e){
                    System.out.println("Please enter number");
                    continue;
                }
                switch(choice){
                    case 0:
                        System.out.println("Returning to the main menu");
                        System.exit(0);
                    case 1:
                        employees.sort(Comparator.comparing(Employee::getEmployeeName));
                        System.out.println("Sorted employees by name successfully");
                        break;
                    case 2:
                        employees.sort(Comparator.comparing(Employee::getCoefficient));
                        System.out.println("Sorted employees by coefficient successfully");
                        break;
                    default:
                        System.out.println("Invalid choice please choose 1/2 or 0");
                }
            }
        }
    }

    public static void searchMenu(){
        System.out.println("Search Menu");
        System.out.println("1. Employee Name");
        System.out.println("2. Employee Department");
        System.out.println("3. By Salary");
        System.out.println("0. Exit");
    }
}
