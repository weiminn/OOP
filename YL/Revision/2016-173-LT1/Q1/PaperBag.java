public class PaperBag extends ItemPack implements Biodegradable, Disposable{

    public PaperBag(String name) {
        super(name);
    }

    @Override
    public int getDaysToBiodegrade() {
        // TODO Auto-generated method stub
        return 42;
    }
    
}
