public class Soldier {
    private String name;
    private double baseAllowance;

    public Soldier(String name, double baseAllowance) {
        this.name = name;
        this.baseAllowance = baseAllowance;
    }

    public String getName() {
        return name;
    }

    public double getBaseAllowance() {
        return baseAllowance;
    }

    public double getGrossAllowance() {
        return baseAllowance;
    }

    @Override
    public String toString() {
        return String.format("%s{name='%s', baseAllowance=%.1f}", "Soldier", name, baseAllowance);
    }
    
}
