package de.ukoeln.idh.teaching.tri.ex11;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
public class ATM {
	/**
	 * The bills available in the currency system (in this case: Euros)
	 */
	int[] bills = new int[] { 500, 200, 100, 50, 20, 10, 5 };
	/**
	 * Withdrawing logic.
	 * 
	 * @param amount The amount to withdraw
	 * @return An array of integers, showing how many of which bill to return (in
	 *         descending order)
	 */
	public int[] withdraw(int amount) {
		int[] numberOfBills = new int[bills.length];
		for (int b = 0; b < bills.length; b++) {
			int currentBill = bills[b];
			numberOfBills[b] = amount / currentBill;
			amount = amount - (numberOfBills[b] * currentBill);
		}
		if (amount == 0) {
			return numberOfBills;
		} else {
			throw new RuntimeException("Cannot withdraw");
		}
	}
	protected boolean canWithdraw(int value) {
		return value % 5 == 0 && value > 0;
	}
	/**
	 * Main user loop. Allows users to enter an integer number or "exit" to leave
	 * the loop.
	 */
	public void run() {
		String userChoice;
		System.out.print("Please enter amount: ");
		try (Scanner in = new Scanner(System.in)) {
			do {
				userChoice = in.next();
				if (userChoice.equalsIgnoreCase("exit")) {
					break;
				} else if (userChoice.matches("^\\d+$")) {
				} else if (userChoice.matches("^\\d{1,10}$")) {
					int userValue = Integer.valueOf(userChoice);
					try {
						if (canWithdraw(userValue)) {
@@ -75,4 +75,4 @@ public static void main(String[] args) {
		new ATM().run();
	}

}
} 