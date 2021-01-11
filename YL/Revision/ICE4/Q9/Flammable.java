public interface Flammable {
    public default void smoke() {
        System.out.println("flammable smoking!");
    }
}
