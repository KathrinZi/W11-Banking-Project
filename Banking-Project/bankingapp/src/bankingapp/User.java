package bankingapp;

public class User {
    private String username;
    private String password;
    private String firstName;
    private Account account;

    public User(String username, String password, String firstName, double initialDeposit, double withdrawLimit, double depositLimit, boolean isSavingsAccount) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        if (isSavingsAccount) {
            this.account = new SavingsAccount(username, initialDeposit, withdrawLimit, depositLimit);
        } else {
            this.account = new CheckingAccount(username, initialDeposit, withdrawLimit, depositLimit);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public Account getAccount() {
        return account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayAccountType() {
        account.displayAccountType();
    }

    public double getBalance() {
        return account.getBalance();
    }

    public void setBalance(double balance) {
        account.setBalance(balance);
    }
}