public class VarArgs {

    // only one var arg per method
    // int... must be the last parameter
    static void walk(int start, int... nums){}

    // DOES NOT COMPILE
    // public void walk(int... nums, int start){}
    // public void walk(int... nums, int... start){}

    public static void main(String[] args) {
        // Can omit Var args when calling
        // nums array will be length of 0
        walk(1);

        // 2 and 3 will be in nums array
        walk(1, 2, 3);

        // EXCEPTION
        walk(1, null);
    }

}
