import java.util.*;

public class ConstructorTest{
    public static void main(String[] args){
        ProjectManager e1 = new ProjectManager("alpha", "201912");        
        ProjectManager e2 = new ProjectManager("beta", "201910", 5000.0);
                
        int num = 1;
        
        System.out.printf("Test %d%n", num);
        //testing if the class is an extension
        System.out.println("Expected: Employee");
        System.out.println("Actual  : " + e1.getClass().getSuperclass().getName());
        System.out.println();
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: true");
        System.out.println("Actual  : " + e1.getName().equals("alpha"));
        System.out.println();        
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: true");
        System.out.println("Actual  : " + e1.getJoinYearMonth().equals("201912"));
        System.out.println();
        
                
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: true");
        System.out.println("Actual  : " + (e2.getTotalSalary() == 5000.0));
        System.out.println();
        
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: true");
        System.out.println("Actual  : " + (e2.getProjects().size() == 0));
        System.out.println();
        
        
        ArrayList<Project> projects = new ArrayList<>();
        Project p1 = new Project("dummy1");
        Project p2 = new Project("dummy2");
        projects.add(p1);
        projects.add(p2);
        ProjectManager e3 = new ProjectManager("beta", "201911", projects);        
                
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: true");
        System.out.println("Actual  : " + e3.getJoinYearMonth().equals("201911"));
        System.out.println();
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: true");
        System.out.println("Actual  : " + (e3.getProjects().size() == 2));
        System.out.println(); 
        
        
    }
}