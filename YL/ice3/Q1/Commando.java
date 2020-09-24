public class Commando extends Soldier{

    private double vocationAllowance;

    public Commando(String name, double baseAllowance, double vocationAllowance){
        super(name, baseAllowance);
        this.vocationAllowance = vocationAllowance;
    }

    @Override
    public double getGrossAllowance(){
        return super.getBaseAllowance() + vocationAllowance;
    }

    @Override
    public String toString() {
        return String.format("Commando{Soldier{name='%s', baseAllowance=%.1f}, vocationAllowance=%.1f}", super.getName(), super.getBaseAllowance(), vocationAllowance);
    }
    
}
