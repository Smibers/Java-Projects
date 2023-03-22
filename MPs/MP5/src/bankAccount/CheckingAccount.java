package bankAccount;

public class CheckingAccount extends Account {
	private double overdraftLimit;
//public double balance;
public String id;

	public CheckingAccount(String id, double balance, double overdraft) {
		super();
		this.overdraftLimit=overdraft;
		this.balance=balance;
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public void deposit(double depo) {
		// TODO Auto-generated method stub
		setBalance(getBalance()+depo);
		System.out.println("your new balance is "+ getBalance());
	}

	@Override
	public void withdraw(double withdraw) {
		// TODO Auto-generated method stub
		if(getBalance()-withdraw >=overdraftLimit*-1) {
			setBalance(getBalance()-withdraw);
			System.out.println("new balance is "+ getBalance());
		}else {
			System.out.println("error, over draft exceeded and cannot be completed");
		}
	}

	@Override
	public String toString() {
		return "CheckingAccount overdraftLimit=" + overdraftLimit + ", accountNumber=" + id + ", balance=" + balance + ", date created: "+ dateCreated;
	}


	


}
