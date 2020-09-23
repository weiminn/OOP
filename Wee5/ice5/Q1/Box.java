package ice5.Q1;

public class Box {
    private int length;
    private int breadth;
    private int height;

    public Box(int b, int l, int h) {
        length = l;
        breadth = b;
        height = h;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBreadth() {
        return breadth;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    @Override
    protected Object clone() {
        return new Box(breadth, length, height);
    }

    @Override
    public boolean equals(Object obj) {
       if(!(obj instanceof Box)){
           return false;
       }

       return 
       ((Box)obj).getBreadth() == breadth &&
       ((Box)obj).getLength() == length && 
       ((Box)obj).getHeight() == height;
    }

    @Override
    public String toString() {
        return String.format("hieght: %s, breadth: %s, length: %s", height, breadth, length);
    }


    
}
