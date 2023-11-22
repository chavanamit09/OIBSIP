package atm;

public class User {
    private String userId;
    private String userPin;
    private Account account;

    public User(String userId, String userPin, String accountNumber) {
        this.userId = userId;
        this.userPin = userPin;
        this.account = new Account(accountNumber);
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String pin) {
        return userPin.equals(pin);
    }

    public Account getAccount() {
        return account;
    }
}