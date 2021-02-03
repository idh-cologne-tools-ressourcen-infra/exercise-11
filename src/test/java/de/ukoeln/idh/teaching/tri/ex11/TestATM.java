package de.ukoeln.idh.teaching.tri.ex11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestATM {

	ATM atm = new ATM();
	
	@Test
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
}
