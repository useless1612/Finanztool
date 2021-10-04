package ase.finanzplaner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteLine {

    public static void deleterow(String account, int lineToRemove){
        File inputFile = new File("~/.finanztool/accounts/" + account);
        File tempFile = new File("~/.finanztool/accounts/" + account + ".tmp");

        
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            int actualLine = 0;
            String currentLine;            
            while((currentLine = reader.readLine()) != null) {
                actualLine++;
                // trim newline when comparing with lineToRemove            
                String trimmedLine = currentLine.trim();
                if(actualLine == lineToRemove) continue;

                // if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 
            // boolean successful = tempFile.renameTo(inputFile);

            if (!inputFile.delete()) {
                System.out.println("Could not delete file");
                return;
              }
         
              //Rename the new file to the filename the original file had.
              if (!tempFile.renameTo(inputFile))
                System.out.println("Could not rename file");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        
    }

    public static void accdestroy(String account) {


        File file = new File("~/.finanztool/accounts/" + account);
        file.delete();


    }






    
}
