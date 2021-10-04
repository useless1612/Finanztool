package ase.finanzplaner.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;


public class Read {
    public static void show(String account){
        String filename = "~/.finanztool/accounts/" + account;
        String strLine = "";

        StringBuilder sBuilder = new StringBuilder();

        try {
            BufferedReader bReader = new BufferedReader(new FileReader(filename));
            for (strLine = bReader.readLine(); strLine != null; strLine = bReader.readLine())
            // while (strLine != null)
            {
                System.out.println(strLine);
               sBuilder.append(strLine);
               sBuilder.append(System.lineSeparator());
            //    strLine = bReader.readLine();
               
           }
           bReader.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static BigDecimal sum(String account){
        String filename = "~/.finanztool/accounts/" + account;
        String strLine = "";
        String date;
        String amount;
        String description;
        BigDecimal sum = new BigDecimal(0);


        StringBuilder sBuilder = new StringBuilder();

        try {
            BufferedReader bReader = new BufferedReader(new FileReader(filename));
            for (strLine = bReader.readLine(); strLine != null; strLine = bReader.readLine())
            //while (strLine != null)
            {
               sBuilder.append(strLine);
               sBuilder.append(System.lineSeparator());
               //amount lesen und addieren
               String[] dataParts = strLine.split("\\|");
               //Arrays.asList(dataParts).forEach(System.out::println);
               date = dataParts[0];     //wird hier eigentlich nicht gebraucht
               amount = dataParts[1];
               //System.out.println(amount);
               description = dataParts[2];      // wird hier eigentlich nicht gebraucht
               sum = sum.add(new BigDecimal(amount));

            //    System.out.println(strLine);

           }
           bReader.close();
           
        //    System.out.println(sum);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sum;

    }

    public static ResultForDiff showdiff(String account) {
        String filename = "~/.finanztool/accounts/" + account;
        String strLine = "";
        String date;
        String amount;
        String description;
        BigDecimal possum = new BigDecimal(0);
        BigDecimal negsum = new BigDecimal(0);
        int amountInt = 0;


        StringBuilder sBuilder = new StringBuilder();

        try {
            BufferedReader bReader = new BufferedReader(new FileReader(filename));
            for (strLine = bReader.readLine(); strLine != null; strLine = bReader.readLine())
            //while (strLine != null)
            {
               sBuilder.append(strLine);
               sBuilder.append(System.lineSeparator());
               //amount lesen und addieren
               String[] dataParts = strLine.split("\\|");
               //Arrays.asList(dataParts).forEach(System.out::println);
               date = dataParts[0];     //wird hier eigentlich nicht gebraucht
               amount = dataParts[1];
               //System.out.println(amount);
               description = dataParts[2];      // wird hier eigentlich nicht gebraucht
               amountInt = Integer.parseInt(amount);

               
            
            if(amountInt > 0){
                possum = possum.add(new BigDecimal(amount));

               }
            else{
                negsum = negsum.add(new BigDecimal(amount));
            }

            //    System.out.println(strLine);
               //strLine = bReader.readLine();
           }
           bReader.close();
           
        //    System.out.println(sum);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return new ResultForDiff(possum, negsum);

        // return sum;
    }

    public static ArrayList<String> showacc() {

        File folder = new File("~/.finanztool/accounts/");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> acclist = new ArrayList<String>();
        
        for (int i = 0; i < listOfFiles.length; i++) {
            acclist.add(listOfFiles[i].getName());



            // if (listOfFiles[i].isFile()) {
            //     System.out.println("Account: " + listOfFiles[i].getName());
            // } 
            // else if (listOfFiles[i].isDirectory()) {
            //     System.out.println("Directory " + listOfFiles[i].getName());
            // }
        }
        return acclist;
    }
}