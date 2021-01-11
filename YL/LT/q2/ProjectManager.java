/*
* Name: Wei Minn
* Email ID: wei.minn.2018
*/


import java.util.*;

public class ProjectManager extends Employee {

    ArrayList<Project> projects = new ArrayList<Project>();

    public ProjectManager(String name, String yyyyMM) {
        super(name, yyyyMM);
    }
    public ProjectManager(String name, String yyyyMM, ArrayList<Project> projects) {
        super(name, yyyyMM);
        this.projects = projects;
    }
    public ProjectManager(String name, String yyyyMM, double salary) {
        super(name, yyyyMM);
        this.salary = salary;
    }

    public void addProject(Project proj){
        projects.add(proj);
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }

    public void removeProject(Project proj){
        Iterator<Project> iter = projects.iterator();
        while (iter.hasNext()) {
            Project _p = iter.next();
            if(_p.equals(proj)){
                iter.remove();
            }
        }
    }

    public int getProjectWorth(){
        int worth = 0;
        Iterator<Project> iter = projects.iterator();
        while (iter.hasNext()) {
            Project _p = iter.next();
            if(_p.isCompleted()) worth += _p.getWorth();
        }
        return worth;
    }

    @Override
    public String toString() {
        return String.format("[Name: %s, type: %s, JoinedDate: %s, projects worth: %d]", 
            getName(),
            "ProjectManager",
            getJoinYearMonth(),
            getProjectWorth()
        );
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if(!(obj instanceof ProjectManager)) return false;
        if(obj instanceof ProjectManager) {
            ProjectManager pm  = (ProjectManager) obj;

            Set<Project> s1 = new HashSet<>(projects);
            Set<Project> s2 = new HashSet<>(pm.projects);

            return super.equals(obj) && s1.containsAll(s1) && s2.containsAll(s1);
        }
        return false;
    }

    public double getBonus() {
        return Double.parseDouble(String.format("%.1f", (double)getProjectWorth()*((double)1/100)));
    }
    

}

