import java.util.ArrayList;


public class ShapeUtility {

    public static Octagon getLargestOctagon(ArrayList<Shape> shapeList){
        Integer largestPos = null;
        
        if(shapeList == null) return null;

        for(int i = 0; i < shapeList.size(); i++){
            if(shapeList.get(i) instanceof Octagon){
                if(largestPos == null){
                    largestPos = i;
                } else {
                    if(((Octagon)shapeList.get(i)).getArea() > ((Octagon)shapeList.get(largestPos)).getArea()){
                        largestPos = i;
                    }
                }       
            }
        }

        if(largestPos == null) return null;
        return (Octagon) shapeList.get(largestPos);
    }

    public static ArrayList<Shape> getAllNonRectangles(ArrayList<Shape> shapeList){
        ArrayList<Shape> toReturn = new ArrayList<>();
        
        if(shapeList == null) return toReturn;

        for (int i = 0; i < shapeList.size(); i++) {
            try {
                Rectangle rect = (Rectangle) shapeList.get(i);
            } catch (ClassCastException ce){
                toReturn.add(shapeList.get(i));
            }
        }
        return toReturn;
    }

    public static ArrayList<Square> getAllSquareWithMinArea(ArrayList<Shape> shapeList, int minArea) {
        ArrayList<Square> toReturn = new ArrayList<>();
        
        if(shapeList == null) return toReturn;
        
        for(int i = 0; i < shapeList.size(); i++){
            try {
                Square square = (Square) shapeList.get(i);
                if(square.getArea() >= minArea){
                    toReturn.add(square);
                }
            } catch (ClassCastException ce){}
        }
        return toReturn;
    }

    public static ArrayList<Rectangle> getAllRectangleWithMinLength(ArrayList<Shape> shapeList, int minLength) {
        ArrayList<Rectangle> toReturn = new ArrayList<>();
        
        if(shapeList == null) return toReturn;
        
        for(int i = 0; i < shapeList.size(); i++){
            try {
                Rectangle rect = (Rectangle) shapeList.get(i);
                if(rect.getLength() >= minLength){
                    toReturn.add(rect);
                }
            } catch (ClassCastException ce){}
        }
        return toReturn;
    }
}
