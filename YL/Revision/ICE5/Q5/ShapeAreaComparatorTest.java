import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by yeowleong on 6/5/14.
 */
public class ShapeAreaComparatorTest {

    public static void main(String[] args) {
            ArrayList<Shape> shapeList = new ArrayList<Shape>();
            shapeList.add(new Octagon(3));
            shapeList.add(new Square(3));
            shapeList.add(new Rectangle(4,3));
            shapeList.add(new Octagon(4));
            shapeList.add(new Square(4));
            shapeList.add(new Rectangle(6,4));
            shapeList.add(new Octagon(8));
            shapeList.add(new Square(8));
            shapeList.add(new Rectangle(8,4));
            shapeList.add(new Octagon(6));
            shapeList.add(new Square(6));
            shapeList.add(new Rectangle(5,4));

        DecimalFormat fmt = new DecimalFormat("#0.00");
        System.out.println("Before sorting:");
            for (Shape s : shapeList) {
                System.out.print(fmt.format(s.getArea()) + ", ");
            }

        System.out.println();
        System.out.println();
        System.out.println("After sorting:");

        Collections.sort(shapeList, new ShapeAreaComparator());
        for (Shape s : shapeList) {
           System.out.print(fmt.format(s.getArea()) + ", ");
        }


    }
}
