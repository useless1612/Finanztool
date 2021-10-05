package ase.finanzplaner.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Read {
    public static void show(String account){
        String filename = "~/.finanztool/accounts/" + account;
        String strLine = "";

        StringBuilder sBuilder = new StringBuilder();

        try {
            BufferedReader bReader = new BufferedReader(new FileReader(filename));
            for (strLine = bReader.readLine(); strLine != null; strLine = bReader.readLine())
            {
                System.out.println(strLine);
               sBuilder.append(strLine);
               sBuilder.append(System.lineSeparator());
               
           }
           bReader.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static ArrayList<String> showacc() {

        File folder = new File("~/.finanztool/accounts/");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> acclist = new ArrayList<String>();
        
        for (int i = 0; i < listOfFiles.length; i++) {
            acclist.add(listOfFiles[i].getName());


        }
        return acclist;
    }
}