public class Overloading {

    public void arr(int[] arr){}
    // public void arr(int... arr){} doesn't compile | java treats array and varargs as same

    //ORDER
    //match by type
    //Promote variable size (long)
    //Autobox first (int -> Integer) and then look for class or superclass (Object)
    //put into varargs of same type


    // java looks for the method with best match for variabled type passed during call
    public void fly(int miles){}
    // if the above method isn't available, java will autobox and call fly(Integer miles)
    public void fly(Integer miles){}

    public void fly(Integer miles, String s){System.out.println("str");}
    // if the above doesn't exist, will look for Object
    public void fly(Integer miles, Object o){System.out.println("o");}

    // if fly(int miles) is not found, integer is converted to long to call this method
    public void fly(long miles){} //will not convert to smaller types (eg. int to short), need to cast explicitly
    // does NOT support multiple conversion steps (int -> long -> Long)

    public static void main(String[] args) {
        Overloading test = new Overloading();
        test.fly(32, "o");
    }
    
}
