import java.util.HashMap;
// storage for all the accounts in the bank
public class Bank {
// mapping between account number to account information
	HashMap<String, Account> accounts;
	
	//constructor - some accounts are created for testing
	public Bank() {
		accounts = new HashMap <String, Account> ();
        addAccount(new Account("acc01",1200));
        addAccount(new Account("acc02",2400));
        addAccount(new Account("acc03",3600));
    }
	
	// add a new account
	public void addAccount (Account acc) {
		accounts.put (acc.getAccNum(),acc);
	}

	// obtain information of an account
	public Account retrieveAccount (String accNum) {
		return accounts.get(accNum);
	}
}