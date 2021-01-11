public class GetSetTest{
    public static void main(String[] args){
        
        ProjectManager e1 = new ProjectManager("alpha", "201912", 4000);
                
        Project p1 = new Project("lta", 100000, true);
        Project p2 = new Project("dummy");
        e1.addProject(p2);        

        int num = 1;
        
        //testing get Projects (count)      
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: true" );
        System.out.println("Actual  : " + (e1.getProjects().size() == 1)); 
        System.out.println(); 
        
        //testing getters
        num++;        
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: 4000.0 ") ;  
        System.out.println("Actual  : " + e1.getTotalSalary()); 
        System.out.println();  
        
        //testing add project and get Projects (count)
        e1.addProject(p1);  
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: true" );
        System.out.println("Actual  : " + (e1.getProjects().size() == 2));  
        System.out.println();  
                
        //testing getBonus and getProjectWorth
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: 1000.0" );
        System.out.println("Actual  : " + e1.getBonus());  
        System.out.println(); 
        
        num++;        
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: 5000.0 ") ;  
        System.out.println("Actual  : " + e1.getTotalSalary()); 
        System.out.println();         
        
        //testing add / remove Project and getBonus()
        ProjectManager e2 = new ProjectManager("beta", "201910");
         
        Project p3 = new Project("abc", 5000, true);
        Project p4 = new Project("def", 10000, true);
        Project p5 = new Project("def");
        p5.setWorth(5500);
        
        e2.setSalary(3000); 
        e2.addProject(p3);
        e2.addProject(p4);
        e2.addProject(p5);

        num++;        
        System.out.printf("Test %d%n", num);               
        System.out.println("Expected: 150.0");
        System.out.println("Actual  : " + e2.getBonus());  
        System.out.println();        
        
        
        e2.removeProject(p4);
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: 3050.0");
        System.out.println("Actual  : " + e2.getTotalSalary());  
        System.out.println();
        
               
        //testing toString()
        num++;
        System.out.printf("Test %d%n", num);
        System.out.println("Expected: [Name: alpha, type: ProjectManager, JoinedDate: 201912, projects worth: 100000]");
        System.out.println("Actual  : " + e1);

    }
}