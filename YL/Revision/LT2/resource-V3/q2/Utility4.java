import java.util.*;


public class Utility4 {

    public static Map<String, Integer> getShortFall(List<Course> courses, Map<String, Integer> demand){
        Map<String, Integer> shortFall = new HashMap<>();
        
        for (Course c : courses) {
            int vac = 0;
            Iterator<Section> iter = c.iterator();
            while(iter.hasNext()) {
                Section sec = iter.next();
                vac += sec.getCapacity()-sec.getEnrolmentNumber();
            }            
            if(demand.containsKey(c.getName()) && (demand.get(c.getName())-vac > 0)) shortFall.put(c.getName(), demand.get(c.getName())-vac);
        }
        return shortFall;
    }
    
    public static void main(String[] args) {
        {
            Course c1 = new Course("Fishing");
            c1.addSection(new Section("G1", 20, 50));
            c1.addSection(new Section("G2", 30, 50));

            Course c2 = new Course("Gardening");
            c2.addSection(new Section("G1", 50, 50));
            c2.addSection(new Section("G2", 45, 50));

            Course c3 = new Course("Sewing");
            c3.addSection(new Section("G1", 30, 50));
            c3.addSection(new Section("G2", 38, 40));

            List<Course> courses = new ArrayList<>();
            courses.add(c1);
            courses.add(c2);
            courses.add(c3);


            Map<String, Integer> demand = new TreeMap<>(Map.of("Fishing", 20, "Gardening", 5));

            Map<String, Integer> result = getShortFall(courses, demand);


            System.out.println("Test 1");
            System.out.println("Expected:{}");
            System.out.println("Actual  :" + result);
            System.out.println();
        }

        {
            Course c1 = new Course("Fishing");
            c1.addSection(new Section("G1", 30, 50));
            c1.addSection(new Section("G2", 20, 50));

            Course c2 = new Course("Gardening");
            c2.addSection(new Section("G1", 50, 50));
            c2.addSection(new Section("G2", 45, 50));

            Course c3 = new Course("Sewing");
            c3.addSection(new Section("G1", 30, 50));
            c3.addSection(new Section("G2", 38, 40));

            List<Course> courses = new ArrayList<>();
            courses.add(c1);
            courses.add(c2);
            courses.add(c3);


            Map<String, Integer> demand = new TreeMap<>(Map.of("Fishing", 20, "Gardening", 6));

            Map<String, Integer> result = getShortFall(courses, demand);


            System.out.println("Test 2");
            System.out.println("Expected:{Gardening=1}");
            System.out.println("Actual  :" + result);
            System.out.println();
        }
        
        {
            Course c1 = new Course("Fishing");
            c1.addSection(new Section("G1", 50, 50));
            c1.addSection(new Section("G2", 29, 50));

            Course c2 = new Course("Gardening");
            c2.addSection(new Section("G1", 50, 50));
            c2.addSection(new Section("G2", 49, 50));

            Course c3 = new Course("Sewing");
            c3.addSection(new Section("G1", 30, 50));
            c3.addSection(new Section("G2", 38, 40));

            Course c4 = new Course("Sleeping");
            c4.addSection(new Section("G1", 30, 50));
            c4.addSection(new Section("G2", 38, 40));

            List<Course> courses = new ArrayList<>();
            courses.add(c1);
            courses.add(c2);
            courses.add(c3);
            courses.add(c4);


            Map<String, Integer> demand = new TreeMap<>(Map.of("Fishing", 20, "Gardening", 6, "Fluffing", 6));

            Map<String, Integer> result = getShortFall(courses, demand);


            System.out.println("Test 3");
            System.out.println("Expected:{Fluffing=6, Gardening=5}");
            System.out.println("Actual  :" + result);
            System.out.println();
        }
        
        {
            Course c1 = new Course("Fishing");
            c1.addSection(new Section("G1", 40, 50));
            c1.addSection(new Section("G2", 32, 50));

            Course c2 = new Course("Gardening");
            c2.addSection(new Section("G1", 50, 50));
            c2.addSection(new Section("G2", 45, 50));

            Course c3 = new Course("Sewing");
            c3.addSection(new Section("G1", 38, 50));
            c3.addSection(new Section("G2", 30, 40));

            List<Course> courses = new ArrayList<>();
            courses.add(c1);
            courses.add(c2);
            courses.add(c3);


            Map<String, Integer> demand = new TreeMap<>(Map.of("Fishing", 20, "Gardening", 5, "Sewing", 20));

            Map<String, Integer> result = getShortFall(courses, demand);


            System.out.println("Test 4");
            System.out.println("Expected:{}");
            System.out.println("Actual  :" + result);
            System.out.println();
        }
        
        {
            Course c1 = new Course("Fishing");
            c1.addSection(new Section("G1", 40, 50));
            c1.addSection(new Section("G2", 40, 50));

            Course c2 = new Course("Gardening");
            c2.addSection(new Section("G1", 45, 50));
            c2.addSection(new Section("G2", 50, 50));

            Course c3 = new Course("Sewing");
            c3.addSection(new Section("G1", 40, 50));
            c3.addSection(new Section("G2", 35, 40));

            List<Course> courses = new ArrayList<>();
            courses.add(c1);
            courses.add(c2);
            courses.add(c3);


            Map<String, Integer> demand = new TreeMap<>(Map.of("Fishing", 20, "Gardening", 5, "Sewing", 20));

            Map<String, Integer> result = getShortFall(courses, demand);


            System.out.println("Test 5");
            System.out.println("Expected:{Sewing=5}");
            System.out.println("Actual  :" + result);
            System.out.println();
        }
        
        
    }

}
