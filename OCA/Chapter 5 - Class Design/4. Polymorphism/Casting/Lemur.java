public class Lemur extends Primate implements HasTail {
    public boolean isHasTailStriped(){
        return false;
    }

    public int age = 10;
    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        //only methods and variables available to the reference type can be called
        HasTail hasTail = lemur;
        //the type of object created determines which methods and variables are stored in the memory

        System.out.println(hasTail.isHasTailStriped());

        Primate primate = new Primate();
        //DOES NOT COMPILE
        //can NOT assign to subclass
        //casting not allowed to unrelated types
        //Lemur l = primate;

        //requires casting
        //will compile but throws ClassCastException because object is not instance of cast class
        //will only run successfully if primate is instanceof lemur
        Lemur l = (Lemur) primate;
    }
}
