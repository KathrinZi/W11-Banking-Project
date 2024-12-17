package services;

import java.util.ArrayList;
import java.util.List;

public class UserService {
 private List<services.User> users;


 public UserService() {
 this.users = new ArrayList<>();
 }


    public boolean addUser() {
        return addUser(null);
    }

    public boolean addUser(User user) {

 for (services.User existingUser : users) {
 if (existingUser.getUsername().equals(user.getUsername())) {
 System.out.println("Error: Username already exists.");
 return false;
 }
 }

 users.add((services.User) user);
 System.out.println("User registered successfully!");
 return true;
 }


  public User login(String username, String password) {
  for (services.User user : users) {
   if (user.getUsername().equals(username)) {
    if (user.getPassword().equals(password)) {
     System.out.println("Login successful! Welcome, " + user.getFirstName() + "!");
     return (User) user;
    } else {
     System.out.println("Error: Incorrect password.");
     return null;
    }
   }
  }
  System.out.println("Error: Username not found.");
  return null;
 }

 public User getUserByUsername(String username) {
 for (services.User user : users) {
 if (user.getUsername().equals(username)) {
 return (User) user;
 }
 }
 return null;
 }

 private class User {
  public Object getUsername() {
   return null;
  }
 }
}
