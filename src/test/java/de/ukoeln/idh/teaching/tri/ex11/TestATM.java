package de.ukoeln.idh.teaching.tri.ex11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestATM {
	ATM atm = new ATM();

	@Test
	public void testCanWithdraw() {
		assertTrue(atm.canWithdraw(5));
		assertFalse(atm.canWithdraw(-5), "Negative numbers can not be taken");
		assertFalse(atm.canWithdraw(11), "Numbers need to be dividable by 5");
	}

	@Test
	public void testWithdrawCorrect() {
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 1, 1 }, atm.withdraw(15));
		assertArrayEquals(new int[] { 0, 0, 0, 1, 0, 0, 1 }, atm.withdraw(55));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 2, 0, 1 }, atm.withdraw(45));
	}

	@Test
	public void testWithdrawException() {
		assertThrows(RuntimeException.class, () -> atm.withdraw(17));
		assertThrows(RuntimeException.class, () -> atm.withdraw(-15));

	}
}
