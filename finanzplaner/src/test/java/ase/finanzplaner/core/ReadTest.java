package ase.finanzplaner.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class ReadTest {

private final static PrintStream standardOut = System.out;
private final static ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();




// @BeforeEach
// public void createTestAcc() {
//     Write.add("testaccount", "12.3.2021", "1", "description");
//     // System.setOut(new PrintStream(outputStreamCaptor));
    
// }


// @BeforeAll
// public static void makeClean(){
//     File file = new File("~/.finanztool/accounts/testaccount");
//     file.delete();
// }

@BeforeEach
public void setUp() {
Write.add("testaccount", "12.3.2021", "1", "description");
// System.setOut(new PrintStream(outputStreamCaptor));
    
}

// @AfterEach
// public void tearDown() {
// System.setOut(standardOut);
// }

@AfterEach
public void deleteAccount() {
// den testaccount löschen
File file = new File("~/.finanztool/accounts/testaccount");
file.delete();
System.setOut(standardOut);


}


    @Test
    void testShow() {
        System.setOut(standardOut);
        System.setOut(new PrintStream(outputStreamCaptor));

        Read.show("testaccount");
        assertEquals("12.3.2021|1|description;", outputStreamCaptor.toString().trim());


    }


    @Test
    void testSum() {
        BigDecimal checksum = new BigDecimal(1);
        Read.sum("testaccount");
        assertEquals(checksum, Read.sum("testaccount"));  


    }

    @Test
    void testSum_add() {
        BigDecimal checksum = new BigDecimal(16);
        Write.add("testaccount", "12.3.2021", "15", "description");
        Read.sum("testaccount");
        assertEquals(checksum, Read.sum("testaccount"));  

    }


    @Test
    void testSum_subtract() {
        BigDecimal checksum = new BigDecimal(11);
        Write.add("testaccount", "12.3.2021", "15", "description");
        Write.add("testaccount", "12.3.2021", "-5", "description");
        Read.sum("testaccount");
        assertEquals(checksum, Read.sum("testaccount"));  

    }

    @Test
    void testShowdiff() {
        BigDecimal checksumpos = new BigDecimal(16);
        BigDecimal checksumneg = new BigDecimal(-5);

        Write.add("testaccount", "12.3.2021", "15", "description");
        Write.add("testaccount", "12.3.2021", "-5", "description");
        ResultForDiff result = Read.showdiff("testaccount");
        System.out.println(checksumneg);
        System.out.println(checksumpos);

        System.out.println( "your incomes amount to: " + result.getFirst().toString() + "€");

        System.out.println("your spendings amount to: " + result.getSecond().toString() + "€");

        assertEquals(checksumpos, result.getFirst());
        assertEquals(checksumneg, result.getSecond());

        

    }

    @Test
    void testShowacc() {
        Boolean accexists = false;
        ArrayList<String> acclist = new ArrayList<String>();
        Write.add("testaccount", "12.3.2021", "15", "description");
        

        acclist = Read.showacc();
        for(int i = 0; i < acclist.size(); i++) {

            if(acclist.get(i).equals("testaccount")){
                accexists = true;
            }

            
        }
        assertTrue(accexists);
              

        
        
    }



}