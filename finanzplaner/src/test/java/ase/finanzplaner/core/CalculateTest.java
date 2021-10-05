package ase.finanzplaner.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateTest {
    


    @BeforeEach
    public void setUp() {
        Write.add("testaccount", "12.3.2021", "1", "description");
    }

    @AfterEach
    public void deleteAccount() {
    // den testaccount löschen
    File file = new File("~/.finanztool/accounts/testaccount");
    file.delete();
    }


    @Test
    void testSum() {
        BigDecimal checksum = new BigDecimal(1);
        Calculate.sumOfAccount("testaccount");
        assertEquals(checksum, Calculate.sumOfAccount("testaccount"));  


    }

    @Test
    void testSum_add() {
        BigDecimal checksum = new BigDecimal(16);
        Write.add("testaccount", "12.3.2021", "15", "description");
        Calculate.sumOfAccount("testaccount");
        assertEquals(checksum, Calculate.sumOfAccount("testaccount"));  

    }


    @Test
    void testSum_subtract() {
        BigDecimal checksum = new BigDecimal(11);
        Write.add("testaccount", "12.3.2021", "15", "description");
        Write.add("testaccount", "12.3.2021", "-5", "description");
        Calculate.sumOfAccount("testaccount");
        assertEquals(checksum, Calculate.sumOfAccount("testaccount"));  

    }

    @Test
    void testShowdiff() {
        BigDecimal checksumpos = new BigDecimal(16);
        BigDecimal checksumneg = new BigDecimal(-5);

        Write.add("testaccount", "12.3.2021", "15", "description");
        Write.add("testaccount", "12.3.2021", "-5", "description");
        ResultForDiff result = Calculate.showIncomeAndExpenses("testaccount");
        System.out.println(checksumneg);
        System.out.println(checksumpos);

        System.out.println( "your incomes amount to: " + result.getFirst().toString() + "€");

        System.out.println("your spendings amount to: " + result.getSecond().toString() + "€");

        assertEquals(checksumpos, result.getFirst());
        assertEquals(checksumneg, result.getSecond());

        

    }


}
