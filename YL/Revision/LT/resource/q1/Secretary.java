

public class Secretary extends Staff {

    private Staff boss;

    public Secretary(String name, String school, Staff boss) {
        super(name, school);
        this.boss = boss;
    }

    public Staff getBoss() {
        return boss;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Secretary){
            Secretary _s = (Secretary) obj;
            return this.getName().equals(_s.getName()) &&
            this.getBoss().equals(_s.getBoss());
        }
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

}
