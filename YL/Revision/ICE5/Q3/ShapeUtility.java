import java.util.ArrayList;

public class ShapeUtility {

    public static Octagon getLargestOctagon(ArrayList<Shape> shapeList){
        if(shapeList == null) return null;
        if(shapeList.size() == 0) return null;

        Octagon toReturn = null;

        for (Shape shape : shapeList) {
            if (shape instanceof Octagon) {
                if(toReturn != null && shape.getArea() > toReturn.getArea()){
                    toReturn = (Octagon) shape;
                }
            }
        }
        return toReturn;
    }

    public static ArrayList<Shape> getAllNonRectangles(ArrayList<Shape> shapeList){
        if(shapeList == null) return null;
        if(shapeList.size() == 0) return null;

        ArrayList<Shape> toReturn = new ArrayList<>();

        for (Shape shape : shapeList) {
            if (!(shape instanceof Rectangle)) {
                toReturn.add(shape);
            }
        }
        return toReturn;
    }

    public static ArrayList<Square> getAllSquareWithMinArea(ArrayList<Shape> shapeList, int minArea){
        if(shapeList == null) return null;
        if(shapeList.size() == 0) return null;

        ArrayList<Square> toReturn = new ArrayList<>();

        for (Shape shape : shapeList) {
            if ((shape instanceof Square) && shape.getArea() >= minArea) {
                toReturn.add((Square)shape);
            }
        }
        return toReturn;
    }
    
    public static ArrayList<Shape> getAllRectangleWithMinLength(ArrayList<Shape> shapeList, int minLength){
        if(shapeList == null) return null;
        if(shapeList.size() == 0) return null;

        ArrayList<Shape> toReturn = new ArrayList<>();

        for (Shape shape : shapeList) {
            if (shape instanceof Rectangle && ((Rectangle)shape).getLength() > minLength) {
                toReturn.add(shape);
            }
        }
        return toReturn;
    }
    
}
