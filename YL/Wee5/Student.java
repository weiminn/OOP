import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class Student implements IHuman {

    @Override   
    public void walk() {
        // TODO Auto-generated method stub
        System.out.println("asdf");
    }
    public static void main(String[] args) {
        Student s = new Student();

        IHuman customHuman = new IHuman(){
            @Override
            public void walk(){
                System.out.println("Anonymous walk");
            }
        };

        customHuman.walk();
    }
}
