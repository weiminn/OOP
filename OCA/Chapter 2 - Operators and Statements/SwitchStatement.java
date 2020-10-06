public class SwitchStatement {
    public static void main(String[] args) {
        int num = 6;
        switch (num){
            case 0:
                System.out.println("zero");
            default:
                System.out.println("default");
            case 7:
                System.out.println("seven");
                break;
        }
    }
    public static void sw() {
        int num  = 7;

        /* Supported datatypes
        int, Integer, byte, Byte
        short, Short, char, Character
        int, Integer, String, enum

        bool and long are not supported
        also their wrappers are not supported
        */
        switch(num){
            //may contain >= 0 case branches
            case 1:
                System.out.println("one");
                break; //optional break
            case 5:
                System.out.println("five");
                break;
            case 7:
                System.out.println("seven");
                break;

            //called if nothing matches
            //can appear anywhere in switch
            default:
                System.out.println("other");
                break;
        }
    }
    
}
