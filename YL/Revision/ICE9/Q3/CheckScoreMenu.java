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


}