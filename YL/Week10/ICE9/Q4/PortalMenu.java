import java.util.*;

public class PortalMenu {
	private PortalController pctrl;

    // constructor
	public PortalMenu(PortalController pctrl) {
		this.pctrl = pctrl;
	}

	// gets account to, account from and amount to transfer from user input and perform transfer
    public void processTransfer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your account number > ");
        String fr = sc.nextLine();

        System.out.print("Enter account to transfer to > ");
        String to = sc.nextLine();

        System.out.print("Enter amount to transfer > ");
        double am = sc.nextDouble();
        sc.nextLine();

        boolean status = pctrl.transfer(fr, to, am);
        if(status){
            System.out.println(am + " is transfered from " + fr + " to " + to);
        } else {
            System.err.println(fr + " has insufficient funds for transfer");
        }
    }        
}