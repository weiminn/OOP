import java.util.Scanner;

public class SearchMenu {
    private SearchCtrl ctrl;

    public SearchMenu(SearchCtrl ctrl) {
        this.ctrl = ctrl;
    }

    public void display() {
        System.out.println("== Interest Group Management System ==");
        System.out.println("1. President Gender Search");
        System.out.println("2. Quit Application");
        System.out.print("Please enter your choice:");
    }

    public void readOption() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            display();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    searchPresident();
                    break;
                case 2:
                    System.out.println("bye bye");
                    break;
                default:
                    System.out.println("Enter a choice between 1 to 2");
            }
        } while (choice != 2);
    }

    public void searchPresident() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Interest Group's name > ");
        String IGName = sc.nextLine();
        System.out.print("Enter the year > ");
        Integer year = sc.nextInt();
        
        Student president = ctrl.searchPresident(IGName, year);
        if(president.getGender() == 'M'){
            System.out.printf("The president %s is a %s%n%n", president.getName(), "gentleman.");
        } else {
            System.out.printf("The president %s is a %s%n%n", president.getName(), "lady.");
        }
    }
}