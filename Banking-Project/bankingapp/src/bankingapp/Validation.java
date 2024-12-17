package bankingapp;

public class Validation {
    public static boolean isValidUsername(String username) {
        return username != null && username.matches("[a-z]+");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public static boolean isPositiveAmount(double amount) {
        return amount > 0;
    }
}