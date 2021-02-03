package de.ukoeln.idh.teaching.tri.ex11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    ATM proofAtm = new ATM();

    @Test
    public void testCanWithdraw() {
        assertTrue(proofAtm.canWithdraw(55));
        assertFalse(proofAtm.canWithdraw(777));
        assertTrue(proofAtm.canWithdraw(2147483645));
        assertFalse(proofAtm.canWithdraw(-2147483645));
        // Was passt da so rein?
        assertFalse(proofAtm.canWithdraw(2147483647));



    }


    @Test
    void withdraw() {
        //TODO
        //"Amount" mit dem Inhalt vom Array vergleichen...? 0,0,0,0,0,0,1 = 5€ etc...
        // 1, 2, don't know what to do...
    }
}
