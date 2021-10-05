package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.Calculate;
import ase.finanzplaner.core.Read;
import ase.finanzplaner.core.ResultForDiff;

public class Overview {
    
    String account;

    public Integer call(String account){
        
        Read.show(account);
        ResultForDiff result = Calculate.showIncomeAndExpenses(account);
        
        System.out.println( "your incomes amount to: " + result.getFirst().toString() + "€");

        System.out.println("your spendings amount to: " + result.getSecond().toString() + "€");

        System.out.println("your account balance is: " + Calculate.sumOfAccount(account) + "€");
        return 0;

    }
}