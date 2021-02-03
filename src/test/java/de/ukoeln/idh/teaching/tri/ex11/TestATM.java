package de.ukoeln.idh.teaching.tri.ex11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestATM {

	ATM atm = new ATM();
	
/*	@Test
	void testInput() {
		assertEquals(true, atm.canWithdraw(5));
		assertEquals(false, atm.canWithdraw(0));
		assertEquals(false, atm.canWithdraw(-5));
		assertEquals(true, atm.canWithdraw(505));
		assertEquals(true, atm.canWithdraw(2147483645));
		assertEquals(false, atm.canWithdraw(Integer.MAX_VALUE));
		assertEquals(false, atm.canWithdraw(Integer.MIN_VALUE));
		assertEquals(false, atm.canWithdraw(-2147483645));
		
		//{ 500, 200, 100, 50, 20, 10, 5 }
		assertArrayEquals(new int[] {1,0,0,0,0,0,0}, atm.withdraw(500));
		assertArrayEquals(new int[] {0,1,0,0,0,0,0}, atm.withdraw(200));
		assertArrayEquals(new int[] {1,0,1,0,0,0,0}, atm.withdraw(600));
		assertArrayEquals(new int[] {1,0,0,1,0,0,0}, atm.withdraw(550));
		assertArrayEquals(new int[] {1,0,0,0,1,0,0}, atm.withdraw(520));
		assertArrayEquals(new int[] {0,0,0,0,0,1,1}, atm.withdraw(15));
		assertArrayEquals(new int[] {0,0,0,0,0,0,1}, atm.withdraw(5));
		
		assertThrows(RuntimeException.class, ()->{atm.withdraw(521);});
		assertThrows(RuntimeException.class, ()->{atm.withdraw(-10);});
	}	
*/		
	
	@Test
	public void testCanWithdraw() {
		assertTrue(atm.canWithdraw(55));
		assertTrue(atm.canWithdraw(175));
		assertTrue(atm.canWithdraw(8595));
		assertTrue(atm.canWithdraw(8892380));
		assertFalse(atm.canWithdraw(0));
		assertFalse(atm.canWithdraw(Integer.MAX_VALUE));
		assertFalse(atm.canWithdraw(Integer.MIN_VALUE));
		assertFalse(atm.canWithdraw(446));
		assertFalse(atm.canWithdraw(-5));

	}
	
	@Test
	public void testWithdraw() {
		assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 1 }, atm.withdraw(5));
		assertArrayEquals(new int[] {0, 0, 0, 0, 1, 0, 1 }, atm.withdraw(25));
		assertArrayEquals(new int[] {0, 0, 0, 1, 0, 1, 0 }, atm.withdraw(60));
		assertArrayEquals(new int[] {0, 0, 0, 2, 0, 0, 0 }, atm.withdraw(100));
		assertArrayEquals(new int[] {17784, 1, 1, 1, 1, 1, 0 }, atm.withdraw(8892380));
		assertArrayEquals(new int[] {1, 1, 1, 1, 1, 1, 1 }, atm.withdraw(885));
		assertThrows(RuntimeException.class, () -> atm.withdraw(-125));
		assertThrows(RuntimeException.class, () -> atm.withdraw(-1));
		assertThrows(RuntimeException.class, () -> atm.withdraw(7777));
		assertThrows(RuntimeException.class, () -> atm.withdraw(Integer.MAX_VALUE));
		assertThrows(RuntimeException.class, () -> atm.withdraw((int) Double.MAX_VALUE));
	}
	
}