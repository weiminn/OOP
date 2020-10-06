public class Baby {
    private boolean isHungry;

    public void setIsHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public void eat(String str) throws NotHungryException{
        if(isHungry){
            System.out.println("Eating " + str);
        } else {
            throw new NotHungryException("rejects " + str);
        }
    }
}
