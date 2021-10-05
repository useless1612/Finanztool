package ase.finanzplaner.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class Calculate {

    public static BigDecimal sumOfAccount(String account){
        String filename = "~/.finanztool/accounts/" + account;
        String strLine = "";
        String amount;
        BigDecimal sum = new BigDecimal(0);
    
    
        StringBuilder sBuilder = new StringBuilder();
    
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(filename));
            for (strLine = bReader.readLine(); strLine != null; strLine = bReader.readLine())
            {
               sBuilder.append(strLine);
               sBuilder.append(System.lineSeparator());
               //amount lesen und addieren
               String[] dataParts = strLine.split("\\|");
               amount = dataParts[1];
               sum = sum.add(new BigDecimal(amount));
    
    
           }
           bReader.close();
           

    
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sum;
    
    }

    public static ResultForDiff showIncomeAndExpenses(String account) {
        String filename = "~/.finanztool/accounts/" + account;
        String strLine = "";
        String amount;
        BigDecimal possum = new BigDecimal(0);
        BigDecimal negsum = new BigDecimal(0);
        int amountInt = 0;
    
    
        StringBuilder sBuilder = new StringBuilder();
    
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(filename));
            for (strLine = bReader.readLine(); strLine != null; strLine = bReader.readLine())
            {
               sBuilder.append(strLine);
               sBuilder.append(System.lineSeparator());
               //amount lesen und addieren
               String[] dataParts = strLine.split("\\|");
               amount = dataParts[1];
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
    }
    
}
