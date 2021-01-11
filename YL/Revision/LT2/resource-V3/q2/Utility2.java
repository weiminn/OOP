import java.util.*;

public class Utility2 {

    public static List<Course> retrieveLowEnrolmentCourses(List<Course> courses) {

        List<Course> toReturn = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            int lowCount = 0;
            int totalSec = 0;
            Iterator<Section> iter = courses.get(i).iterator();
            while(iter.hasNext()) {
                Section sec = iter.next();
                totalSec++;
                if(sec.getEnrolmentNumber() < ((double)sec.getCapacity()/2)){
                    lowCount++;
                }
            }

            if(lowCount >= ((double)totalSec)/3){
                toReturn.add(courses.get(i));
            }
        }

        return toReturn;
        // return toReturn.toArray(new Course[toReturn.size()]);
        
    }

    public static void main(String[] args) {
        Course c1 = new Course("Fishing");
        c1.addSection(new Section("G1", 20,25));
        c1.addSection(new Section("G2", 23,25));

        Course c2 = new Course("Gardening");
        c2.addSection(new Section("G1", 11,25));
        c2.addSection(new Section("G2", 13,25));

        Course c3 = new Course("Sewing");
        c3.addSection(new Section("G1", 30,35));
        c3.addSection(new Section("G2",45,45));
        c3.addSection(new Section("G3",40,45));
        c3.addSection(new Section("G4",41,45));

        Course c4 = new Course("Fluff");
        c4.addSection(new Section("G1", 8,17));
        c4.addSection(new Section("G2",45,45));
        c4.addSection(new Section("G3",40,45));


        List<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);

        List<Course> result = retrieveLowEnrolmentCourses(courses);
        System.out.println("Test");
        System.out.println("Expected:[Gardening[G1, G2], Fluff[G1, G2, G3]]");
        System.out.println("Actual  :" + result);

    }

}
