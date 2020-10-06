public class BabyFeedMain {
    public static void main (String[] args) {

        System.out.println("Start feeding");
        try {
            Baby b = new Baby();
            b.setIsHungry(true);
            b.eat("baby food");
            
            b.setIsHungry(false);
            b.eat("hamburger");
        } catch (NotHungryException e) {
            System.out.println("There's a problem! " + e.getMessage());
        }
        System.out.println("End feeding");
    }
}
