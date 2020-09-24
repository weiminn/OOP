public class Laptop extends java.lang.Object {
    
    private String name;

    public Laptop(String name) {
        super();
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Laptop l = (Laptop) obj;

        if(this.name == l.getName()){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Laptop l1 = new Laptop("Acer");
        Laptop l2 = l1;
        Laptop l3 = new Laptop("Lenovo");

        System.out.println(l1.equals(l2));
        System.out.println(l1.equals(l3));
    }
}
