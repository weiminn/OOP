public class SwitchStatement {
    public static void main(String[] args) {
        int num = 6;
        switch (num){
            case 0:
                System.out.println("zero");

            //will execute default block until return or first break statement after "seven"
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
            //need to be matching type
            case 1:
                System.out.println("one");
                break; //optional break
            case 5:
                System.out.println("five");
                break;
            case 7:
                System.out.println("seven");
                break;

            //optional default
            //called if nothing matches
            //can appear anywhere in switch
            default:
                System.out.println("other");
                break;
        }
    }
    
}
