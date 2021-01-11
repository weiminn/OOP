import java.util.Objects;

public class Box {
    private int length;
    private int breadth;
    private int height;

    public Box(int length, int breadth, int height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Box(length, breadth, height);
    }

    @Override
    public boolean equals(Object obj) {
        Box box = (Box) obj;
        return box.breadth == this.breadth && box.length == this.length && box.height == this.height;
    }

    @Override
    public String toString() {
        return String.format("height: <%d>, breadth: <%d>, length: <%d>", this.height, this.breadth, this.length);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(length, breadth, height);
    }

}
