import java.util.ArrayList;

/**
 * Created by yeowleong on 6/5/14.
 */
public class ShapeUtilityTest {
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


        System.out.println("Test getLargestOctagon:");
        System.out.println(ShapeUtility.getLargestOctagon(null));
        System.out.println(ShapeUtility.getLargestOctagon(new ArrayList<Shape>()));
        System.out.println(ShapeUtility.getLargestOctagon(shapeList));

        System.out.println();
        System.out.println("Test getAllNonRectangles:");
        System.out.println(ShapeUtility.getAllNonRectangles(null));
        System.out.println(ShapeUtility.getAllNonRectangles(new ArrayList<Shape>()));
        System.out.println(ShapeUtility.getAllNonRectangles(shapeList));

        System.out.println();
        System.out.println("Test getAllSquareWithMinArea:");
        System.out.println(ShapeUtility.getAllSquareWithMinArea(null, 20));
        System.out.println(ShapeUtility.getAllSquareWithMinArea(new ArrayList<Shape>(), 20));
        System.out.println(ShapeUtility.getAllSquareWithMinArea(shapeList, 20));

        System.out.println();
        System.out.println("Test getAllRectangleWithMinLength:");
        System.out.println(ShapeUtility.getAllRectangleWithMinLength(null, 6));
        System.out.println(ShapeUtility.getAllRectangleWithMinLength(new ArrayList<Shape>(), 6));
        System.out.println(ShapeUtility.getAllRectangleWithMinLength(shapeList, 6));
    }
}
