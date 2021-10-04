package ase.finanzplaner.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteLineTest {


private final static PrintStream standardOut = System.out;
private final static ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

// @BeforeEach
// public void setUp() {
//     // Write.add("testaccount", "12.3.2021", "1", "description");
//     System.setOut(new PrintStream(outputStreamCaptor));
    
// }


    @BeforeEach
    public void createTestAcc() {
        Write.add("testaccount", "12.3.2021", "1", "description");
        Write.add("testaccount", "12.3.2021", "2", "description");
        Write.add("testaccount", "12.3.2021", "3", "description");
        Write.add("testaccount", "12.3.2021", "4", "description");
        System.setOut(new PrintStream(outputStreamCaptor));
        
    }


    @AfterEach
    public void deleteAccount() {
    // den testaccount löschen
    File file = new File("~/.finanztool/accounts/testaccount");
    file.delete();
    System.setOut(standardOut);
    }


    @Test
    void testDeleterow() {
        // System.setOut(standardOut);
        // System.setOut(new PrintStream(outputStreamCaptor));
        DeleteLine.deleterow("testaccount", 3);

        Read.show("testaccount");
        assertEquals("12.3.2021|1|description;" + System.getProperty("line.separator") + "12.3.2021|2|description;" + System.getProperty("line.separator") + "12.3.2021|4|description;", outputStreamCaptor.toString().trim());


    }





    @Test
    void testDeleteacc() {
        Boolean exists = false;
        DeleteLine.accdestroy("testaccount");
        File file = new File("~/.finanztool/accounts/testaccount");

        if(file.exists() && !file.isDirectory()) { 
            exists = true;
        }

        assertTrue(!exists);
        
    }
}
