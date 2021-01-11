import java.util.*;

public class Section {
    private String number;
    private Course course;
    private Staff[] staff;


    public Section(String number, Course course, Staff[] staff) {
        this.number = number;
        this.course = course;
        this.staff = staff;
    }

    public String getNumber() {
        return number;
    }

    public Course getCourse() {
        return course;
    }

    public Staff[] getStaff() {
        return staff;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Section){
            Section _s = (Section) obj;
            if(!this.getCourse().equals(_s.getCourse())) return false;

            Set<Staff> set1 = new HashSet<Staff>(Arrays.asList(staff));
            Set<Staff> set2 = new HashSet<Staff>(Arrays.asList(_s.getStaff()));
            for (Staff _staff : staff) {
                if(!set2.contains(_staff)) return false;
            }
            for (Staff _staff : _s.getStaff()) {
                if(!set1.contains(_staff)) return false;
            }
            return true;
        }
        return false;
    }

}
