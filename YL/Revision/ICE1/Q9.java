public class Q9 {

    public static void main(String[] args) {
        char c = 'a';
        int age = 9;

        // fragment A
        if (c == 'a' && ++age == 10){
            age++;
        }
        System.out.print(age);

        // fragment B
        if (c == 'a' & ++age == 10){
            age++;
        }
        System.out.print(age);

        // fragment C
        if (c != 'a' && ++age == 10){
            age++;
        }
        System.out.print(age);

        // fragment D
        if (c != 'a' || ++age == 10){
            age++;
        }
        System.out.print(age);

        // fragment E
        if (c == 'a' || ++age == 10){
            age++;
        }
        System.out.print(age);
        
        // fragment F
        if (c != 'a' | ++age == 10){
            age++;
        }
        System.out.print(age);

    }
}