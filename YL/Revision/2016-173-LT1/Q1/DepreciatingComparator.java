import java.util.*;

public class DepreciatingComparator extends ValuableComparator {

    public DepreciatingComparator() {
        super();
    }

    public int compare(Valuable a, Valuable b){
        if(a instanceof Depreciating && b instanceof Depreciating){
            Depreciating x = (Depreciating) a;
            Depreciating y = (Depreciating) b;
            if(Double.compare(x.getDepreciationRate(), y.getDepreciationRate()) != 0) return Double.compare(x.getDepreciationRate(), y.getDepreciationRate());
            return super.compare(a, b); 
        } else {
            if(a instanceof Depreciating) {
                return 1;
            }
            if(b instanceof Depreciating) {
                return -1;
            }
            return super.compare(a, b);            
        }
        // return 0;
    }
}