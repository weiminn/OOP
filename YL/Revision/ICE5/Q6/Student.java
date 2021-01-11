public class Student implements Comparable<Student>{
 
    private int age;
    private String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return name.compareTo(((Student) o).getName());
    }
}
