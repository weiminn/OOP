public class WebColorTest {
    public static void main(String[] args) {
        int tc_num = 1;
        {
            System.out.println("Test " + tc_num++);
            WebColor webcolor = new WebColor("#FFEEA0");
            System.out.println("Expected:255:238:160");
            System.out.println("Actual  :" + webcolor);
            System.out.println();
        }

        {
            System.out.println("Test " + tc_num++);
            try {
                System.out.println("Expected:Pass");
                // G is not a valid hexadecimal
                WebColor webcolor = new WebColor("#G0EEA0");
                System.out.println("Actual  :Fail");
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equals("invalid hexstring")) {
                    System.out.println("Actual  :Pass");
                } else {
                    System.out.println("Actual  :Fail");
                }
            }
            System.out.println();
        }

        {
            System.out.println("Test " + tc_num++);
            try {
                System.out.println("Expected:Pass");
                // string is too short .. length 6
                WebColor webcolor = new WebColor("#0EEA0");
                System.out.println("Actual  :Fail");
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equals("invalid hexstring")) {
                    System.out.println("Actual  :Pass");
                } else {
                    System.out.println("Actual  :Fail");
                }
            }
            System.out.println();
        }

        
        {
            System.out.println("Test " + tc_num++);
            try {
                System.out.println("Expected:Pass");
                // doesn't start with a hash character
                WebColor webcolor = new WebColor("00EEA0");
                System.out.println("Actual  :Fail");
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equals("invalid hexstring")) {
                    System.out.println("Actual  :Pass");
                } else {
                    System.out.println("Actual  :Fail");
                }
            }
            System.out.println();
        }

        {
            System.out.println("Test " + tc_num++);
            WebColor webcolor = new WebColor(255, 238, 160);
            System.out.println("Expected:#FFEEA0");
            System.out.println("Actual  :" + webcolor.toHexString());
            System.out.println();
        }


        {
            System.out.println("Test " + tc_num++);
            try {
                System.out.println("Expected:Pass");
                //256 is outside the valid range (0-255)
                WebColor webcolor = new WebColor(256, 2, 2);
                System.out.println("Actual  :Fail");
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equals("invalid int value")) {
                    System.out.println("Actual  :Pass");
                } else {
                    System.out.println("Actual  :Fail");
                }
            }
            System.out.println();
        }
        
        
        
        {
            System.out.println("Test " + tc_num++);
            try {
                System.out.println("Expected:Pass");
                //-10 is outside the valid range (0-255)
                WebColor webcolor = new WebColor(255, 2, -10);
                System.out.println("Actual  :Fail");
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equals("invalid int value")) {
                    System.out.println("Actual  :Pass");
                } else {
                    System.out.println("Actual  :Fail");
                }
            }
            System.out.println();
        }

        
        {
            System.out.println("Test " + tc_num++);

                System.out.println("Expected:90:84:56");
                WebColor c = new WebColor(255, 238, 160);
                WebColor c2 = new WebColor(90, 90, 90);
                WebColor result = c.add(c2);
                System.out.println("Actual  :" + result);
            System.out.println();
        } 
    }
}
