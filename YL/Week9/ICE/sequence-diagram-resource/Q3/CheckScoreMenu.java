import java.util.Scanner;

public class CheckScoreMenu {
    private CheckScoreCtrl ctrl;

    public CheckScoreMenu(CheckScoreCtrl ctrl) {
        this.ctrl = ctrl;
    }

    public void display() {
        System.out.println("== Quiz Management System ==");
        System.out.println("1. Check student's score");
        System.out.println("2. Quit Application");
        System.out.print("Please enter your choice: ");
    }

    public void readOption() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            display();
            choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    checkScore();
                    break;
                case 2 :
                    System.out.println("bye bye");
                    break;
                default :
                    System.out.println("Enter a choice between 1 to 2");
            }
        } while (choice != 2);
    }

    void checkScore() {
        Scanner sc = new Scanner(System.in);       

        System.out.print("Enter the student's name > ");
        String sName = sc.nextLine();
        System.out.print("Enter the quiz's name > ");
        String qName = sc.nextLine();

        try {
            double z = ctrl.calculateDifferenceFromAverage(sName, qName);
        
            if(z == 0){
                System.out.printf("%s is sitting on the fence!%n", sName);
            } else if(z > 0) {
                System.out.printf("%s is %.1f marks above average!%n", sName, z);
            } else {
                System.out.printf("%s is %.1f marks below average!%n", sName, Math.abs(z));
            }
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
    }


}