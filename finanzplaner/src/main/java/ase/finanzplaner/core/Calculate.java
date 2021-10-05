package ase.finanzplaner.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class Calculate {

    public static BigDecimal sumOfAccount(String account){
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

    public static ResultForDiff showIncomeAndExpenses(String account) {
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
               date = dataParts[0];     //wird hier eigentlich nicht gebraucht
               amount = dataParts[1];
               description = dataParts[2];      // wird hier eigentlich nicht gebraucht
               amountInt = Integer.parseInt(amount);
    
               
            
            if(amountInt > 0){
                possum = possum.add(new BigDecimal(amount));
    
               }
            else{
                negsum = negsum.add(new BigDecimal(amount));
            }

           }
           bReader.close();
           

    
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return new ResultForDiff(possum, negsum);
    
        // return sum;
    }
    
}
