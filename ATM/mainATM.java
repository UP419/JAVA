package ATMProject;

import java.util.Scanner;

public class mainATM {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int tmp = 1;
		helperATM atm = new helperATM();
		while(true) {
			printChoices();
			tmp = scan.nextInt();
			if(tmp == 0) {
				break;
			}
			atm.makeMove(tmp);
		}
	}
	public static void printChoices() {
		System.out.println("Exit: 0");
		System.out.println("Create New Account: 1");
		System.out.println("Log in : 2");
		System.out.print("Choose an option: ");
	}
}
