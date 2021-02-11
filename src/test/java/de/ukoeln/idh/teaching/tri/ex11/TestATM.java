package de.ukoeln.idh.teaching.tri.ex11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestATM {

	ATM atm = new ATM();
	
	/**
	 * This test compares the banknote arrays to the selected amount.
	 */
	@Test
	public void testWithdraw() {
		assertArrayEquals(new int[] {0, 0, 0, 0, 2, 0, 1 }, atm.withdraw(45));
		assertArrayEquals(new int[] {0, 1, 1, 0, 0, 1, 0 }, atm.withdraw(310));
		assertArrayEquals(new int[] {1, 0, 0, 0, 1, 0, 1 }, atm.withdraw(525));
		assertArrayEquals(new int[] {2, 0, 0, 1, 0, 0, 0 }, atm.withdraw(1050));
		assertThrows(RuntimeException.class, ()->{atm.withdraw(1584);});
		assertThrows(RuntimeException.class, ()->{atm.withdraw(-100);});
	}
	/**
	 * This test @param value asserts if it is possible to Withdraw the value given, the maximal and minimal value.
	 */
	@Test
	public void testCanWithdraw(int value) {
		assertTrue(atm.canWithdraw(value));
		assertFalse(atm.canWithdraw(-value));
		assertFalse(atm.canWithdraw(Integer.MAX_VALUE));
		assertFalse(atm.canWithdraw(Integer.MIN_VALUE));
	}
}