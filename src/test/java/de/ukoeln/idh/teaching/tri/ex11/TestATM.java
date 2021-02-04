package de.ukoeln.idh.teaching.tri.ex11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestATM {
	
	ATM atm = new ATM();
			
			public void testWithdraw() {
		assertArrayEquals(new int[] {0,0,0,0,0,0,1}, atm.withdraw(5));
		assertArrayEquals(new int[] {0,0,0,0,0,1,1}, atm.withdraw(15));
		assertArrayEquals(new int[] {0,0,0,0,1,0,1}, atm.withdraw(25));
		assertArrayEquals(new int[] {0,0,0,1,0,0,1}, atm.withdraw(55));
		assertArrayEquals(new int[] {0,0,1,0,0,0,1}, atm.withdraw(105));
		assertArrayEquals(new int[] {0,1,0,0,0,0,1}, atm.withdraw(205));
		assertArrayEquals(new int[] {1,0,0,0,0,0,1}, atm.withdraw(505));
		assertThrows(RuntimeException.class, ()->{atm.withdraw(111);});
		
	}
	@Test
	public void testCanWithdraw() {
		assertTrue(atm.canWithdraw(25));
		assertFalse(atm.canWithdraw(-25));
		assertTrue(atm.canWithdraw(205));
		assertFalse(atm.canWithdraw(44));
		assertTrue(atm.canWithdraw(300));
		assertFalse(atm.canWithdraw(Integer.MAX_VALUE));
		assertTrue(atm.canWithdraw(Integer.MIN_VALUE));
		assertFalse(atm.canWithdraw(0));	
	}
}