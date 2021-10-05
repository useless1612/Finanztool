package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.Calculate;
import ase.finanzplaner.core.ResultForDiff;

public class ShowDiff {

    public Integer call(String account){
        ResultForDiff result = Calculate.showIncomeAndExpenses(account);
        
        System.out.println( "your incomes amount to: " + result.getFirst().toString() + "€");

        System.out.println("your spendings amount to: " + result.getSecond().toString() + "€");

        System.out.println("your account balance is: " + Calculate.sumOfAccount(account) + "€");

        
        
        return 0;

    }

}


