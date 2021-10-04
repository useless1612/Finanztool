package ase.finanzplaner.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class WriteTest {
    @AfterEach
    public void deleteAccount() {
        // den testaccount löschen
        File file = new File("~/.finanztool/accounts/testaccount");
        file.delete();
}



    @Test
    void testIfFileisCreated() {
        Boolean exists = false;
        Write.add("testaccount", "12.3.2021", "1", "description");

        File file = new File("~/.finanztool/accounts/testaccount");
        if(file.exists() && !file.isDirectory()) { 
            exists = true;
        }
        assertTrue(exists);

    }

    @Test
    void testContentsOfFile(){
        try {
            Write.add("testaccount", "12.3.2021", "1", "description");

            BufferedReader bReader = new BufferedReader(new FileReader("~/.finanztool/accounts/testaccount"));
            String line = bReader.readLine();
            bReader.close();
            assertEquals("12.3.2021|1|description;", line);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    // @AfterAll
    // public static void deleteAccount() {
    // // den testaccount löschen
    // File file = new File("~/.finanztool/accounts/testaccount");
    // file.delete();
    // }
}
