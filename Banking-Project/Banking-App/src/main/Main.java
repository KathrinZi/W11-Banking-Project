package main;

import models.Account.GoldAccount;
import models.Account.PlatinumAccount;
import models.Account.SilverAccount;
import models.User;
import models.Account.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
 private static final Map<String, User> users = new HashMap<>(); // Speichert alle registrierten Benutzer
 private static User loggedInUser = null; // Speichert den aktuell eingeloggten Benutzer
 private static final Scanner scanner = new Scanner(System.in);

 public static void main(String[] args) {
 boolean running = true;

 while (running) {
 System.out.println("\n--- Welcome to the Banking Application ---");
 System.out.println("1. Signup");
 System.out.println("2. Login");
 System.out.println("3. Exit");
 System.out.print("Choose an option: ");

 int choice = scanner.nextInt();
 scanner.nextLine(); // Buffer leeren

 switch (choice) {
 case 1:
 signup();
 break;
 case 2:
 login();
 break;
 case 3:
 System.out.println("Exiting application. Goodbye!");
 running = false;
 break;
 default:
 System.out.println("Invalid option. Try again.");
 }
 }
 }

 private static void signup() {
 System.out.print("Enter a unique username (lowercase only): ");
 String username = scanner.nextLine();
 if (users.containsKey(username)) {
 System.out.println("Error: Username already exists.");
 return;
 }

 System.out.print("Enter your password (min. 6 characters): ");
 String password = scanner.nextLine();
 if (password.length() < 6) {
 System.out.println("Error: Password must be at least 6 characters.");
 return;
 }

 System.out.print("Enter your first name: ");
 String firstName = scanner.nextLine();

 System.out.println("Choose account type: \n1. Platinum\n2. Gold\n3. Silver");
 int accountTypeChoice = scanner.nextInt();
 scanner.nextLine();

 Account account;
 switch (accountTypeChoice) {
 case 1:
 account = new PlatinumAccount();
 break;
 case 2:
 account = new GoldAccount();
 break;
 case 3:
 account = new SilverAccount();
 break;
 default:
 System.out.println("Invalid account type. Defaulting to Silver.");
 account = new SilverAccount();
 }

 System.out.print("Enter currency (e.g., USD, EUR, GBP): ");
 String currency = scanner.nextLine();


 User newUser = new User(username, password, firstName, account, currency);
 users.put(username, newUser);

 System.out.println("Signup successful! Please log in.");
 }

 private static void login() {
 System.out.print("Enter your username: ");
 String username = scanner.nextLine();

 System.out.print("Enter your password: ");
 String password = scanner.nextLine();

 User user = users.get(username);
 if (user != null && user.checkPassword(password)) {
 loggedInUser = user;
 System.out.println("Login successful. Welcome, " + user.getFirstName() + "!");
 showLoggedInMenu();
 } else {
 System.out.println("Error: Invalid username or password.");
 }
 }

 private static void showLoggedInMenu() {
 boolean loggedIn = true;

 while (loggedIn) {
 System.out.println("\n--- Logged-In Menu ---");
 System.out.println("1. Show Balance");
 System.out.println("2. Deposit");
 System.out.println("3. Withdraw");
 System.out.println("4. Transaction History");
 System.out.println("5. Logout");
 System.out.print("Choose an option: ");

 int choice = scanner.nextInt();
 scanner.nextLine();

 switch (choice) {
 case 1:
 loggedInUser.showBalance();
 break;
 case 2:
 System.out.print("Enter deposit amount: ");
 double depositAmount = scanner.nextDouble();
 scanner.nextLine();
 loggedInUser.deposit(depositAmount);
 System.out.println("Deposit successful.");
 break;
 case 3:
 System.out.print("Enter withdrawal amount: ");
 double withdrawAmount = scanner.nextDouble();
 scanner.nextLine();
 loggedInUser.withdraw(withdrawAmount);
 break;
 case 4:
 loggedInUser.showTransactionHistory();
 break;
 case 5:
 System.out.println("Logging out...");
 loggedIn = false;
 loggedInUser = null;
 break;
 default:
 System.out.println("Invalid option. Try again.");
 }
 }
}


 public static class Account {
 protected double balance;

 public Account() {
 this.balance = 0;
 }

 public double getBalance() {
 return balance;
 }

 public void deposit(double amount) {
if (amount > 0) {
 balance += amount;
 }
}

 public boolean withdraw(double amount) {
 if (amount > 0 && balance >= amount) {
 balance -= amount;
 return true;
 }
 System.out.println("Error: Insufficient balance or invalid amount.");
 return false;
 }
 }

 private static class PlatinumAccount extends Account {
 public PlatinumAccount() {
 super();
 }
 }

 private static class GoldAccount extends Account {
 public GoldAccount() {
 super();
 }
 }

 private static class SilverAccount extends Account {
 public SilverAccount() {
 super();
 }
 }
}
