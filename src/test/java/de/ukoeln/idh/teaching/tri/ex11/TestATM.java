package de.ukoeln.idh.teaching.tri.ex11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestATM {
	ATM atm = new ATM();

	@Test
	public void testCanWithdraw() {
		assertTrue(atm.canWithdraw(5));
		assertTrue(atm.canWithdraw(255));
		assertTrue(atm.canWithdraw(445));
		assertFalse(atm.canWithdraw(0));
		assertFalse(atm.canWithdraw(Integer.MAX_VALUE));
		assertFalse(atm.canWithdraw(Integer.MIN_VALUE));
		assertFalse(atm.canWithdraw(446));
		assertFalse(atm.canWithdraw(-5));

	}

	@Test
	public void testWithdraw(){
		assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 1 }, atm.withdraw(5));
		assertArrayEquals(new int[] {0, 0, 0, 1, 0, 0, 0 }, atm.withdraw(50));
		assertArrayEquals(new int[] {0, 0, 0, 1, 0, 0, 1 }, atm.withdraw(55));
		assertArrayEquals(new int[] {1, 1, 1, 1, 1, 1, 1 }, atm.withdraw(885));
		assertThrows(RuntimeException.class, () -> atm.withdraw(-25));
		assertThrows(RuntimeException.class, () -> atm.withdraw(Integer.MAX_VALUE));
		assertThrows(RuntimeException.class, () -> atm.withdraw((int) Double.MAX_VALUE));
	}
}
