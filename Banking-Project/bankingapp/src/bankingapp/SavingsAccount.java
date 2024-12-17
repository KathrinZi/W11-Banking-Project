package bankingapp;

public class SavingsAccount extends Account {

    public SavingsAccount(String username, double balance, double withdrawLimit, double depositLimit) {
        super(username, balance, withdrawLimit, depositLimit);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Savings Account");
    }
}