public class Commando extends Soldier {
    private double vocationAllowance;
    public Commando(String name, double baseAllowance, double vocationAllowance) {
        super(name, baseAllowance);
        this.vocationAllowance = vocationAllowance;
    }

    @Override
    public double getGrossAllowance() {
        return super.getBaseAllowance() + vocationAllowance;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%s{%s, vocationAllowance=%.1f}", "Commando", super.toString(), getGrossAllowance());
    }
    
}
