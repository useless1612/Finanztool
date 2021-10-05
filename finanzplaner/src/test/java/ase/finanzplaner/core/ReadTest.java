package ase.finanzplaner.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class ReadTest {

private final static PrintStream standardOut = System.out;
private final static ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();





@BeforeEach
public void setUp() {
Write.add("testaccount", "12.3.2021", "1", "description");
    
}


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