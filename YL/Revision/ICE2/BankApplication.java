public class BankApplication {
    public static void main (String[] args) {
        BankAccount accountOne = new BankAccount();
        BankAccount accountTwo = new BankAccount(1200);

        System.out.println("Balance in accountOne: $"
                + accountOne.getBalance());
        System.out.println("Balance in accountTwo: $"
                + accountTwo.getBalance());
        System.out.println();

        accountOne.deposit(200);
        System.out.println("After depositing $200 in accountOne");
        System.out.println("Balance in accountOne: $"
                + accountOne.getBalance());
        System.out.println();

        accountTwo.withdraw(250);
        System.out.println("After withdrawal of $250 from accountTwo");
        System.out.println("Balance in accountTwo: $"
                + accountTwo.getBalance());
        System.out.println();

        accountOne.transfer(120, accountTwo);
        System.out.println("After transferring $120 from accountOne"
                + " into accountTwo");
        System.out.println("Balance in accountOne: $"
                + accountOne.getBalance());
        System.out.println("Balance in accountTwo: $"
                + accountTwo.getBalance());

        System.out.println("\nWithdrawing $600 from accountOne, successful?");
        System.out.println(accountOne.withdraw(600));

    }
}
