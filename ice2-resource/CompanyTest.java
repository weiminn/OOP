import java.util.*;

public class CompanyTest {

    public static void main(String[] args) {

        Company company = new Company("UMS");
        
        Spouse spouse = new Spouse("Kate", 37);
        Employee emp = new Employee("John", 5, 2500.00, 'M', spouse);
        company.addEmployee(emp);

        System.out.println("Total Salary(before): $" + company.getAllEmployeesSalary());

        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nEnter ID: ");
        int id  = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();
        
        System.out.print("Enter gender: ");
        String genderStr = sc.next();
        char gender = genderStr.charAt(0);
        sc.nextLine();

        Employee emp2 = new Employee(name, id, salary, gender);

        company.addEmployee(emp2);
        System.out.println("\nTotal Salary(after addition): $" + company.getAllEmployeesSalary());
        

        checkEmployee(company, 4);
        checkEmployee(company, 5);
    }

    static void checkEmployee(Company comp, int id){
        Employee emp = comp.getEmployee(id);
        if(emp.getSpouse() != null){
            System.out.printf("%nName: %s, Salary: $%.2f, Status: %s", emp.getName(), emp.getSalary(), "Married");
            System.out.println("\nSpouse's name: " + emp.getSpouse().getName());
        }
        else {
            System.out.printf("%nName: %s, Salary: $%.2f, Status: %s", emp.getName(), emp.getSalary(), "Single");
        }
    }
}
