	 * @return An array of integers, showing how many of which bill to return (in
	 *         descending order)
	 */


public int[] withdraw(int amount) {
	int[] numberOfBills = new int[bills.length];
	if(amount > 0){
		for (int b = 0; b < bills.length; b++) {
			int currentBill = bills[b];
			numberOfBills[b] = amount / currentBill;
			amount = amount - (numberOfBills[b] * currentBill);
		}
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
				int userValue = Integer.parseInt(userChoice);
				try {
					if (canWithdraw(userValue)) {
						int[] bills = withdraw(userValue);
						System.out.println(StringUtils.join(bills, ','));
					} else {
						System.out.println("Incorrect value");
					}
				} catch (RuntimeException e) {
					System.out.println("Incorrect value");
				}
			} else {
				System.out.println("Incorrect value");
			}
			System.out.println();
			System.out.print("Please enter amount: ");
		} while (in.hasNext());
	}
}

public static void main(String[] args) {
	// create a new instance and launch it
	new ATM().run();

}

}

