public class Baby {

    private boolean isHungry;

    public void setIsHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public void eat(String f) throws NotHungryException {
        if(isHungry){
            System.out.println("Eating " + f);
        } else {
            throw new NotHungryException("rejects " + f);
        }
        
    }
    
}
