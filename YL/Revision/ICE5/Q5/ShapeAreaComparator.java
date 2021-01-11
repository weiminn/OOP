/**
 * ShapeAreaComparator
 */

import java.util.*;

public class ShapeAreaComparator implements Comparator<Shape> {

    public int compare(Shape o1, Shape o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }

    
}

