// entity class containing information on an account in the bank
public class Account {
	private String accNum; // account number
	private double balance; // account's balance
	
	// constructor
	public Account(String accNum, double balance) {
		this.accNum = accNum;
		this.balance = balance;
	}
	
	//getter methods
	public String getAccNum () {
		return accNum;
	}
	public double getBalance () {
		return balance;
	}
	
	// add an amount to the balance
	public void add (double amt) {
		balance += amt;
	}
	// deduct an amount to the balance
	public void deduct (double amt) {
		balance -= amt;
	}
}