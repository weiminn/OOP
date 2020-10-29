import java.util.Scanner;

public class CheckMembershipMenu {
    private CheckMembershipCtrl ctrl;

    public CheckMembershipMenu(CheckMembershipCtrl ctrl) {
        this.ctrl = ctrl;
    }

    public void display() {
        System.out.println("== Team Management System ==");
        System.out.println("1. Check student's team enrolment");
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
                    checkMembershipDuration();
                    break;
                case 2 :
                    System.out.println("bye bye");
                    break;
                default :
                    System.out.println("Enter a choice between 1 to 2");
            }
        } while (choice != 2);
    }

    // complete the checkMembershipDuration method here
    void checkMembershipDuration(){
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the student's name > ");
        String sName = sc.nextLine();
        System.out.print("Enter the team's name > ");
        String tName = sc.nextLine();

        int res = ctrl.checkMembershipDuration(sName, tName);
        if(res == -1){
            System.out.printf("%s is not in the team %s%n", sName, tName);
        } else {
            // System.out.println("Returned: " + res);
            if(res == 0) {
                System.out.printf("%s joined the team when the team is formed%n", sName);
            } else {
                System.out.printf("%s joined %d days after team is formed%n", sName, res);
            }
        }
    }
}