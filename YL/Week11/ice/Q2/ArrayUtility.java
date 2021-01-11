public class ArrayUtility {
    public static String printArray(int[] array) {
        if(array == null) return "";
        String toPrint = "[";

        for (int i = 0; i < array.length; i++) {
            toPrint += String.format("<%d>", array[i]);
        }

        toPrint += "]";

        return toPrint;
    }

    public static int sum(int[] array){
        if(array == null) return 0;
        int total = 0;

        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }

        return total;
    }

    public static int[] twoTimes(int[] array){
        if(array == null) return null;
        int[] toReturn = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            toReturn[i] = array[i]*2;
        }
        return toReturn;
    }

    public static void reverse(int[] array){
        if(array == null) return;
        for(int i = 0; i < array.length/2; i++){
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
    }
    
}
