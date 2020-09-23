package smu.bidding;

import smu.dm.*;
import smu.object.*;

public class App {
  
  
  public static void main(String[] args) {
    StudentManager sm =  new StudentManager();
    Student s = new Student();
    
    CourseManager cm = new CourseManager();
    Course c = new Course();
    
    Venue v = new Venue();
    
    System.out.println("==========================");
    System.out.println("Hello from smu.bidding.App");
    System.out.println("==========================");
  }
}