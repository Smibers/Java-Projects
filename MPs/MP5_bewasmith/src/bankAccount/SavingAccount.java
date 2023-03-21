package bankAccount;

public class SavingAccount extends Account {
public static double annualInterestRate =.02;
public double minDeposit;
public static double monthlyFee = 10;
public String id;
public double balance;

public SavingAccount(String id, double balance,double minDeposit) {
	super();
	this.minDeposit = minDeposit;
	this.id = id;
	this.balance = balance;
}


public static double getAnnualInterestRate() {
	return annualInterestRate;
}

public void setMinDeposit(double minDeposit) {
	this.minDeposit = minDeposit;
}

public static double getMonthlyFee() {
	return monthlyFee;
}

public static void setMonthlyFee(double monthlyFee) {
	SavingAccount.monthlyFee = monthlyFee;
}



public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}


@Override
public void withdraw(double withdraw) {
	// TODO Auto-generated method stub
	if(getBalance()- withdraw >=0) {
		setBalance(getBalance()-withdraw);
		System.out.println("balance now: "+getBalance());
	}else {
		System.out.println("cannot complete command");
	}
}


@Override
public void deposit(double depo) {
	// TODO Auto-generated method stub
	if (depo>=minDeposit) {
		setBalance(getBalance()+depo);
		System.out.println("balance is now "+getBalance());
	}else {
		System.out.println("savings minimum deposit not met");
	}
	
}


@Override
public String toString() {
	return "SavingAccount minDeposit=" + minDeposit + ", id=" + id +   " ,Balance=" + getBalance() + ", date created: "+ dateCreated;
}


	




}
