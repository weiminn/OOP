/*
* Name: Wei Minn
* Email ID: wei.minn.2018
*/

import java.util.Comparator;

public class EmployeeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub

        if(!(o1.getClass().equals(o2.getClass()))){
            if(o1 instanceof ProjectManager) return 1;
            return -1;
        }

        if(o1 instanceof ProjectManager){
            ProjectManager p1 = (ProjectManager) o1;
            ProjectManager p2 = (ProjectManager) o2;

            if(Integer.compare(p1.getProjectWorth(), p2.getProjectWorth()) != 0 ) return -Integer.compare(p1.getProjectWorth(), p2.getProjectWorth());
        }

        Employee e1 = (Employee) o1;
        Employee e2 = (Employee) o2;

        if(e1.getName().compare(e2.getName()) != 0) return e1.getName().compare(e2.getName());

        return Integer.compare(Integer.parseInt(e1.getJoinYearMonth()),Integer.parseInt(e2.getJoinYearMonth()));
    }
}
