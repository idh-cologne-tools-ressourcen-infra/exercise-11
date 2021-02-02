package de.ukoeln.idh.teaching.tri.ex11;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestATM {
	ATM testATM = new ATM();
	
	
	
	@Test
	public void testCanWithdraw() {
 		if (testATM.canWithdraw(39) == true
 				|| testATM.canWithdraw(-3)
 				|| testATM.canWithdraw(0)) {
 			fail("canWithdraw test failed");
 		}
 	}

 	@Test
 	public void testWithdraw() {
 		int[] withdraw80testNOB = new int[] {0,0,0,1,1,1,0};
 		int[] withdraw80 = testATM.withdraw(80);

 		assertArrayEquals(withdraw80testNOB, withdraw80);

 		assertThrows(RuntimeException.class, () -> {testATM.withdraw(678);});
 	  
	}
}
