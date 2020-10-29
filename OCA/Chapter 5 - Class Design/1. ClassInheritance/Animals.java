//All classes automatically inherts from java.lang.Object
//compiler automatically inserts extends java.lang.Object

//public means Animals can be referenced and used in any class
public class Animals {
    private int age;
    protected int size;
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void setSize(int size) {
        this.size = size;
    }
    
}
