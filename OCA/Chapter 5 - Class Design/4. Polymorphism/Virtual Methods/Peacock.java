public class Peacock extends Bird {

    //at runtime, the instance uses the overridden version of the method
    public String getName() {
        return "peacock";
    }    

    public static void main(String[] args) {
        Bird bird = new Peacock();
        bird.displayInformation();
    }
}
