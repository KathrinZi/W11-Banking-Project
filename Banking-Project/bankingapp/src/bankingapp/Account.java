package bankingapp;

public abstract class Account {
    private String username;
    private double balance;
    private double withdrawLimit;
    private double depositLimit;

    public Account(String username, double balance, double withdrawLimit, double depositLimit) {
        this.username = username;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
        this.depositLimit = depositLimit;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public double getDepositLimit() {
        return depositLimit;
    }

    // Abstract method to be implemented in subclasses
    public abstract void displayAccountType();
}