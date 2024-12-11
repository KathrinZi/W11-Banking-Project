package models;

public class User {
 private String username;
 private String password;
 private String firstName;
 private double balance;
 private double withdrawLimit;
 private boolean isActive;


 public User(String username, String password, String firstName, double initialDeposit, double withdrawLimit) {
 this.username = username.toLowerCase();
 this.password = password;
 this.firstName = firstName;
 this.balance = initialDeposit;
 this.withdrawLimit = withdrawLimit;
 this.isActive = true;
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

 public double getBalance() {
 return balance;
}

 public double getWithdrawLimit() {
 return withdrawLimit;
}

 public boolean isActive() {
 return isActive;
 }

 public void deactivate() {
 this.isActive = false;
 }

 public void deposit(double amount) {
 this.balance += amount;
 }

 public boolean withdraw(double amount) {
 if (amount > this.withdrawLimit) {
 System.out.println("Exceeds withdraw limit.");
 return false;
 }
 if (amount > this.balance) {
 System.out.println("Insufficient funds.");
 return false;
 }
this.balance -= amount;
return true;
 }
}
