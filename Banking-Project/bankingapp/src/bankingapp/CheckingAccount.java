package bankingapp;

public class CheckingAccount extends Account {

    public CheckingAccount(String username, double balance, double withdrawLimit, double depositLimit) {
        super(username, balance, withdrawLimit, depositLimit);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Checking Account");
    }
}