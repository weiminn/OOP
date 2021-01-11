import java.util.*;

public class EqualsTest{    
    
    public static void main(String[] args){
        ProjectManager e1 = new ProjectManager("alpha", "201912");
        ProjectManager e2 = new ProjectManager("beta", "201910");
        ProjectManager e3 = new ProjectManager("alpha", "201910");
        ProjectManager e4 = new ProjectManager("beta", "201910");
        
        int num = 1;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected : false");
        System.out.println("Actual   : " + e1.equals(e2));
        System.out.println();
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected : false");
        System.out.println("Actual   : " + e1.equals(e3));
        System.out.println();
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected : true");
        System.out.println("Actual   : " + e2.equals(e4));
        System.out.println();
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected : false");
        System.out.println("Actual   : " + e1.equals(new String("alpha")));
        System.out.println();
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected : false");
        System.out.println("Actual   : " + e2.equals(null));
        System.out.println();
     
        
        
        ArrayList<Project> projects = new ArrayList<>();
        Project p1 = new Project("nlb", 20000, false);
        projects.add(p1);
        
        Employee e5 = new ProjectManager("alpha", "201912", projects);
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected : false");
        System.out.println("Actual   : " + e1.equals(e5));
        System.out.println("");
                        
        Project p2 = new Project("moe", 10000, false);
        Project p3 = new Project("moe", 20000, true);
        e2.addProject(p2);    
        e4.addProject(p3); 
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected : true");
        System.out.println("Actual   : " + e2.equals(e4));
        System.out.println();
                                
        Project p4 = new Project("nlb", 20000, false);
               
        e4.addProject(p4);
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected : false");
        System.out.println("Actual   : " + e4.equals(e2));
        System.out.println();
        
        
        ArrayList<Project> projects1 = new ArrayList<>(); 
        ArrayList<Project> projects2 = new ArrayList<>();

        projects1.add(new Project("one", 10000, false));
        projects1.add(new Project("two", 2000, false));
        
        
        projects2.add(new Project("two"));
        projects2.add(new Project("one", 10000, false));
        
        ProjectManager e6 = new ProjectManager("alpha", "201910", projects1);
        ProjectManager e7 = new ProjectManager("alpha", "201910", projects2);
        
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected : true");
        System.out.println("Actual   : " + e6.equals(e7));
        System.out.println();
                      
    }

}