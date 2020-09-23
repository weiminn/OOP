public class ShapeAreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape s1, Shape s2){
        if(s1.getArea() < s2.getArea()){
            return -1;
        } else if(s1.getArea() > s2.getArea()){
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Shape shape){
        return true;
    }
    
}
