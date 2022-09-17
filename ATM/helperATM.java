package ATMProject;

import java.util.HashMap;
import java.util.Scanner;

public class helperATM {
	HashMap<String, String> data = new HashMap();
	HashMap<String, Integer> balance = new HashMap();
	Scanner scan = new Scanner(System.in);

	public helperATM() {
	
	}
	void makeMove(int tmp) {
		if(tmp == 1) {
			newAccount();
		}else if(tmp == 2) {
			logIn();
		}else {	
			System.out.println("Invalid Command!");
		}
	}
	void newAccount() {
		System.out.print("Enter Account num: ");
		String accNum = scan.nextLine();
		if(data.containsKey(accNum)) {
			System.out.println("Account already exists!");
		}else {
			System.out.print("Enter Account password: ");
			String password = scan.nextLine();
			data.put(accNum, password);
			balance.put(accNum, 0);
		}
	}
	void logIn() {
		System.out.print("Enter Account num: ");
		String accNum = scan.nextLine();
		if(!(data.containsKey(accNum))) {
			System.out.println("Account doesn't exist");
		}else {
			System.out.print("Enter Account password: ");
			String password = scan.nextLine();
			if(!data.get(accNum).equals(password)) {
				System.out.println("Password is incorrect! ");
			}else {
				chooseOption(accNum);
			}
		}
	}
	void chooseOption(String accNum) {
		while(true) {
			System.out.println("Exit : 0.");
			System.out.println("Withdraw money: 1.");
			System.out.println("Deposit money: 2.");
			System.out.println("Check Balance: 3.");
			System.out.print("Choose an option: ");
			int tmp = scan.nextInt();
			if(tmp == 0) {
				break;
			}else if(tmp == 1) {
				withdrawMoney(accNum);
			}else if(tmp == 2){
				depositMoney(accNum);
			}else {
				checkBalance(accNum);
			}
		}
	}
	void withdrawMoney(String accNum) {
		int num = 0;
		System.out.print("How much money would you like to withdraw?: ");
		num = scan.nextInt();
		if(num > balance.get(accNum)) {
			System.out.println("You don't have enough money!");
		}else {
			balance.put(accNum, balance.get(accNum) -num);
			System.out.println("Balance updated!");
		}
	}
	void depositMoney(String accNum) {
		System.out.print("How much money will you deposit?: ");
		int tmp = 0;
		tmp = scan.nextInt();
		balance.put(accNum, balance.get(accNum) + tmp);
		System.out.println("Balance updated!");
	}
	void checkBalance(String accNum) {
		int tmp = balance.get(accNum);
		System.out.println("Your balance is " + tmp);
	}
}
