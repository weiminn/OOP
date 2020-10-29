public class WrapperClasses {
    public static void main(String[] args) {
        new Boolean(true);
        new Byte((byte) 1);
        new Short((short) 1);
        new Integer(1);
        new Long(1);
        new Float(1);
        new Double(1);
        new Character('c');

        //string to primitive
        Boolean.parseBoolean("true");
        Byte.parseByte("1");
        Short.parseShort("1");
        Integer.parseInt("1");
        Long.parseLong("1");
        Float.parseFloat("1");
        Double.parseDouble("1");
        //no parsing for char

        //String to wrapper
        Boolean.valueOf("true");
        //same for all other types
        //except char which don't have
    }
    
}
