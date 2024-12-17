package models.Account;

public abstract class Account {
    protected double balance;
    protected double withdrawLimit;
    protected double depositLimit;

    public Account(double withdrawLimit, double depositLimit) {
        this.balance = 0;
        this.withdrawLimit = withdrawLimit;
        this.depositLimit = depositLimit;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0 && amount <= depositLimit) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Error: Deposit amount exceeds the limit or is invalid.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance && amount <= withdrawLimit) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Error: Withdrawal failed. Check balance or withdrawal limit.");
            return false;
        }
    }

    public boolean transfer(double amount, Account recipient) {
        if (this.withdraw(amount)) {
            recipient.deposit(amount);
            return true;
        }
        return false;
    }
}