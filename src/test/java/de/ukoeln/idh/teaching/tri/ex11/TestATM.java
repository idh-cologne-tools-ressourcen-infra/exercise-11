package de.ukoeln.idh.teaching.tri.ex11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestATM {

	private ATM atm = new ATM();

	@Test
	public void CombinationTest() {

		assertArrayEquals(new int[] {1,0,0,0,0,0,0}, atm.withdraw(500));

		assertArrayEquals(new int[] {0,0,0,0,0,0,1}, atm.withdraw(5));

		assertArrayEquals(new int[] {1,0,0,0,0,0,1}, atm.withdraw(505));

		assertArrayEquals(new int[] {1,0,0,1,0,0,1}, atm.withdraw(555));

	}

	@Test
	public void FailTest() {

		assertEquals(false, atm.canWithdraw(0));

		assertEquals(false, atm.canWithdraw(-500));

		assertEquals(false, atm.canWithdraw(Integer.MAX_VALUE));

		assertEquals(false, atm.canWithdraw(Integer.MIN_VALUE));

	}
}
