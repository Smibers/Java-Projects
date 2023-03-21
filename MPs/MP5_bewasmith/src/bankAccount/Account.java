package bankAccount;

import java.time.LocalDate;

public abstract class Account {
public String accountNumber;
public double balance;
protected static LocalDate dateCreated = LocalDate.of(2022, 12, 1);


public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public static LocalDate getDateCreated() {
	return dateCreated;
}


public abstract void withdraw(double withdraw);

public abstract void deposit(double depo);

}
