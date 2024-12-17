package models;

import main.Main;
import models.Account.Account;

import java.util.ArrayList;
import java.util.List;

public class User {
 private String username;
 private String password;
 private String firstName;
 private Account account; // Verweis auf die Account-Klasse
 private String currency;
 private final List<String> transactionHistory;

 public User(String username, String password, String firstName, Main.Account account, String currency) {
     this.transactionHistory = new ArrayList<>();
 }

 public String getUsername() {
  return username;
 }

 public boolean checkPassword(String password) {
  return this.password.equalsIgnoreCase(password.trim());
 }

 public String getFirstName() {
  return firstName;
 }

 public Account getAccount() {
  return account;
 }

 public String getCurrency() {
  return currency;
 }

 public void addTransaction(String transaction) {
  transactionHistory.add(transaction);
 }

 public void showBalance() {
  System.out.println("Your current balance is: $" + account.getBalance() + " (" + currency + ")");
 }

 public void deposit(double amount) {
  account.deposit(amount);
  transactionHistory.add("Deposited: $" + amount + " (" + currency + ")");
 }

 public void withdraw(double amount) {
  if (account.withdraw(amount)) {
   transactionHistory.add("Withdrew: $" + amount + " (" + currency + ")");
  }
 }

 public void showTransactionHistory() {
  if (transactionHistory.isEmpty()) {
   System.out.println("No transactions available.");
  } else {
   System.out.println("\nTransaction History:");
   for (String transaction : transactionHistory) {
    System.out.println(transaction);
   }
  }
 }
}