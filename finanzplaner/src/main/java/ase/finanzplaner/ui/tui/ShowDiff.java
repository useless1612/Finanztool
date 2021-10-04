package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.Read;
import ase.finanzplaner.core.ResultForDiff;

public class ShowDiff {

    public Integer call(String account){
        ResultForDiff result = Read.showdiff(account);
        
        System.out.println( "your incomes amount to: " + result.getFirst().toString() + "€");

        System.out.println("your spendings amount to: " + result.getSecond().toString() + "€");

        System.out.println("your account balance is: " + Read.sum(account) + "€");

        
        
        return 0;

    }

}


