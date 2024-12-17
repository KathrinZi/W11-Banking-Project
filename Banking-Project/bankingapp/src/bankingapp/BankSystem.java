package bankingapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankSystem {
    private Map<String, User> users = new HashMap<>();
    private User currentUser = null;

    public void signup() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username (lowercase only): ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }

        System.out.print("Enter password (min 6 characters): ");
        String password = scanner.nextLine();
        if (password.length() < 6) {
            System.out.println("Password too short.");
            return;
        }

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double depositAmount = scanner.nextDouble();

        System.out.print("Enter withdraw limit: ");
        double withdrawLimit = scanner.nextDouble();

        System.out.print("Enter deposit limit: ");
        double depositLimit = scanner.nextDouble();

        System.out.print("Is this a savings account (true/false): ");
        boolean isSavingsAccount = scanner.nextBoolean();

        // Create new user and account
        User newUser = new User(username, password, firstName, depositAmount, withdrawLimit, depositLimit, isSavingsAccount);
        users.put(username, newUser);

        System.out.println("Signup successful! Please login.");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            loggedInMenu();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void loggedInMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLogged-In User Menu:");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Reset Password");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    resetPassword();
                    break;
                case 5:
                    logout();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void showBalance() {
        System.out.println("Current balance: " + currentUser.getBalance());
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        if (amount <= 0 || amount > currentUser.getAccount().getDepositLimit()) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        double newBalance = currentUser.getBalance() + amount;
        currentUser.setBalance(newBalance);
        System.out.println("Deposit successful. New balance: " + newBalance);
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        if (amount <= 0 || amount > currentUser.getAccount().getWithdrawLimit()) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        double newBalance = currentUser.getBalance() - amount;
        currentUser.setBalance(newBalance);
        System.out.println("Withdrawal successful. New balance: " + newBalance);
    }

    public void resetPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter current password: ");
        String currentPassword = scanner.nextLine();

        if (!currentPassword.equals(currentUser.getPassword())) {
            System.out.println("Incorrect password.");
            return;
        }

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        currentUser.setPassword(newPassword);
        System.out.println("Password reset successful.");
    }

    public void logout() {
        currentUser = null;
        System.out.println("Logged out successfully.");
    }
}