import models.User;
import services.UserService;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
UserService userService = new UserService();

boolean running = true;

while (running) {
 // MainMenu
System.out.println("\n=== Main Menu ===");
 System.out.println("1. Signup");
 System.out.println("2. Login");
 System.out.println("3. Exit");
 System.out.print("Choose an option: ");

 int choice = scanner.nextInt();
 scanner.nextLine();

 switch (choice) {
 case 1:
 // Signup
 System.out.println("=== Signup ===");
 System.out.print("Enter username (lowercase): ");
 String username = scanner.nextLine().toLowerCase();

 System.out.print("Enter password (min 6 characters): ");
 String password = scanner.nextLine();

 System.out.print("Enter your first name: ");
 String firstName = scanner.nextLine();

 System.out.print("Enter your initial deposit: ");
 double initialDeposit = scanner.nextDouble();
 System.out.print("Enter your withdraw limit: ");
 double withdrawLimit = scanner.nextDouble();
 scanner.nextLine();

 // NewUser
 User newUser = new User(username, password, firstName, initialDeposit, withdrawLimit);
 // add
 if (userService.addUser(newUser)) {
 System.out.println("Signup successful! Please log in.");
 } else {
 System.out.println("Signup failed. Username might already exist.");
 }
 break;

 case 2:
 // Login
 System.out.println("=== Login ===");
 System.out.print("Enter username: ");
 String loginUsername = scanner.nextLine().toLowerCase();

 System.out.print("Enter password: ");
 String loginPassword = scanner.nextLine();

 // LoginEx
  User loggedInUser = userService.login(loginUsername, loginPassword);
 if (loggedInUser != null) {
 boolean loggedIn = true;
 while (loggedIn) {
 System.out.println("\n--- Logged-In Menu ---");
 System.out.println("1. Show Balance");
 System.out.println("2. Logout");
 System.out.print("Choose an option: ");

 int loggedInChoice = scanner.nextInt();
 scanner.nextLine();

 switch (loggedInChoice) {
 case 1:
  System.out.println("Your balance is: $" + loggedInUser.getBalance());
 break;

 case 2:
 // Logout
 System.out.println("You have logged out.");
 loggedIn = false;
 break;

 default:
 System.out.println("Invalid option. Please try again.");
 }
 }
 }
 break;

 case 3:
 running = false;
 System.out.println("Exiting the application. Goodbye!");
 break;

 default:
 System.out.println("Invalid option. Please try again.");
 }
 }
 }
}
