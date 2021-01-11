public class Smoker implements  Human, Flammable {

    @Override
    public void smoke(){
        Human.super.smoke();
        Flammable.super.smoke();
    }

}
