package first;

public class BankAccount {
private double checkingBalance=0;
private double savingsBalance=0;
private static int accountsNum = 0;
private static double totalAmount=0;


public BankAccount() {
	accountsNum++;
}
public double getCheckingBalance() {
	return checkingBalance;
}
public double getSavingsBalance() {
	return savingsBalance;
}
public void deposit(double amount,String type) {
	if(type=="checking" || type=="Checking") {
		this.checkingBalance += amount;
	}
	else if(type == "saving"||type=="Saving") {
		this.savingsBalance += amount;
	}
	else {
		System.out.println("Wrong info");
	}
}
public void withdraw(double amount) {
	if(amount<(this.savingsBalance)){
		this.savingsBalance-=amount;
		System.out.println("Process sucess! you have withdrawn: $"+amount);
		System.out.println("You dont have enough money!");
	}
	else {
		System.out.println("You dont have enough money!");
	}
}
public void getTotal() {
	double total;
	total=this.checkingBalance+this.savingsBalance;
	System.out.println("Your total balance is : $"+total);
}
}
