//provide some reusable methods and variables
//but do not want an instance of it
public abstract class AbstractAnimal {

    //requires subclasses to implement this method
    protected abstract void move();

    //DOES NOT COMPILE
    //can NOT have body even if the body is empty
    // protected abstract void swim() {
    //     System.out.println("Swimming");
    // }

    //can NOT be abstract and private

    //can NOT be final

}
