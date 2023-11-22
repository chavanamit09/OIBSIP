package atm;

import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
            balance += amount;
            transactionHistory.add(new Transaction(amount));

    }

    public void withdraw(double amount) {
        if (amount>0 && amount<= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction(-amount));
            System.out.println("₹" + amount + " withdrawn from the account.");
          //  System.out.println("Available balance is: "+ getBalance());
        }
        else {
            System.out.println("Sorry you don't have sufficient Balance.");

        }
    }

    public void transfer(Account recipient, double amount) {
        if ( amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("₹" + amount + " transferred to the recipient's account.");
            transactionHistory.add(new Transaction(-amount));
        }
        else {
            System.out.println("Sorry you don't have sufficient Balance.");
        }
    }
}

