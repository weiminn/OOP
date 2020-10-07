public class For {
    public static void main(String[] args) {
        outerLoop: for (int i = 0; i < args.length; i++) {
            innerLoop: for (int j = 0; j < args.length; j++) {
                if (j == 5) {
                    break outerLoop;
                    //breaks immediate parent loop by default
                }
            }
        }

        theLoop: for (int i = 0; i < 10; i++) {
            if (i == 5){
                //skips current iteration and continue from next iteration
                continue theLoop;
            }
            
        }
    }
    
}
