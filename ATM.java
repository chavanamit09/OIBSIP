package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private User currentUser;
    private ArrayList<User> users;

    public ATM() {
        users = new ArrayList<>();
        // Initialize users and their accounts here
        users.add(new User("amit_c","4992","12345"));
        users.add(new User("demo1","1909","98745612301"));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        loginUser(userId, pin);

        if (currentUser != null) {
            boolean quit = false;
            while (!quit) {
                System.out.println("ATM Menu:");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.println("6. Check balance");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        displayTransactionHistory();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        quit = true;
                        break;
                    case 6:
                        balance();
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        } else {
            System.out.println("Invalid User ID or PIN. Please try again.");
        }
    }

    private void loginUser(String userId, String pin) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.validatePin(pin)) {
                currentUser = user;
                break;
            }
        }
    }

    private void displayTransactionHistory() {
        Account account = currentUser.getAccount();
        ArrayList<Transaction> transactions = account.getTransactionHistory();
        System.out.println("Transaction History for Account: " + account.getAccountNumber());
        for (Transaction transaction : transactions) {
            String type = transaction.getAmount() > 0 ? "Deposit" : "Withdrawal";
            double amount = Math.abs(transaction.getAmount());
            System.out.println("Type: " + type + ", Amount: " + amount + "₹, Date: " + transaction.getTimestamp());
        }
    }

    private void withdraw() {
        Account account = currentUser.getAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void deposit() {
        Account account = currentUser.getAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if(amount>0) {
            account.deposit(amount);
            System.out.println("₹" + amount + " deposited into the account.");
        }
        else {
            System.out.println("Please enter valid a mount.");
        }
    }

    private void transfer() {
        Account account = currentUser.getAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter recipient's account number: ");
        String recipientAccountNumber = scanner.nextLine();
        Account recipient = findAccountByNumber(recipientAccountNumber);
        if (recipient == null) {
            System.out.println("Recipient's account not found.");
            return;
        }
        System.out.print("Enter the amount to transfer: ₹");
        double amount = scanner.nextDouble();
        account.transfer(recipient, amount);

    }

    private Account findAccountByNumber(String accountNumber) {
        for (User user : users) {
            if (user.getAccount().getAccountNumber().equals(accountNumber)) {
                return user.getAccount();
            }
        }
        return null;
    }

    private void balance(){
        Account account=currentUser.getAccount();
        System.out.println("Available Balance is: "+ account.getBalance());
    }
}
