package ase.finanzplaner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

    public static void add(String account, String date, String amount, String description) {
        String filename = "~/.finanztool/accounts/" + account;
        File file = new File(filename);

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        try {
            FileWriter fWriter = new FileWriter(filename, true);

            
            fWriter.write(date + "|" + amount + "|" + description + ";");
            fWriter.write(System.getProperty( "line.separator" ));
            
            fWriter.close();
            System.out.printf("successfully wrote to file");


        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.printf("something went wrong");
            e.printStackTrace();
        }
        




    }
    
    
}
