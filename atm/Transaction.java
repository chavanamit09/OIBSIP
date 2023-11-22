package atm;

import java.util.Date;

public class Transaction {
	 private double amount;
	    private Date timestamp;

	    public Transaction(double amount) {
	        this.amount = amount;
	        this.timestamp = new Date();
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public Date getTimestamp() {
	        return timestamp;
	    }

}
