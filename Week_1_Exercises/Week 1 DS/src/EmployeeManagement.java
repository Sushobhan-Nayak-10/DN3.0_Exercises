import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

// Employee class
class Employee {
    private int employeeId;
    private String employeeName;
    private double salary;

    public Employee(int employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary + "]";
    }
}

// SortingMethod interface
interface SortingMethod {
    void applySorting(List<Employee> employees);
}

// Sort by Employee ID method
class SortByEmployeeIdMethod implements SortingMethod {
    @Override
    public void applySorting(List<Employee> employees) {
        employees.sort(Comparator.comparingInt(Employee::getEmployeeId));
    }
}

// Sort by Employee Name method
class SortByEmployeeNameMethod implements SortingMethod {
    @Override
    public void applySorting(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getEmployeeName));
    }
}

// Sort by Salary method
class SortBySalaryMethod implements SortingMethod {
    @Override
    public void applySorting(List<Employee> employees) {
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
    }
}

// EmployeeManager class
class EmployeeManager {
    private SortingMethod sortingMethod;

    public void setSortingMethod(SortingMethod sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public void sortEmployees(List<Employee> employees) {
        sortingMethod.applySorting(employees);
    }
}

// Main class
public class EmployeeManagement {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", 75000));
        employees.add(new Employee(2, "Bob", 55000));
        employees.add(new Employee(3, "Charlie", 45000));
        employees.add(new Employee(4, "Dave", 65000));
        employees.add(new Employee(5, "Eve", 85000));

        // Create an EmployeeManager
        EmployeeManager employeeManager = new EmployeeManager();

        // Sort by Employee ID
        employeeManager.setSortingMethod(new SortByEmployeeIdMethod());
        employeeManager.sortEmployees(employees);
        System.out.println("Sorted by Employee ID:");
        employees.forEach(System.out::println);

        // Sort by Employee Name
        employeeManager.setSortingMethod(new SortByEmployeeNameMethod());
        employeeManager.sortEmployees(employees);
        System.out.println("Sorted by Employee Name:");
        employees.forEach(System.out::println);

        // Sort by Salary
        employeeManager.setSortingMethod(new SortBySalaryMethod());
        employeeManager.sortEmployees(employees);
        System.out.println("Sorted by Salary:");
        employees.forEach(System.out::println);
    }
}
