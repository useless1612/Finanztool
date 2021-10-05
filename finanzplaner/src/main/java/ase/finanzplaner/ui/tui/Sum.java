package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.Calculate;

public class Sum {

    public Integer call(String account){
        
        System.out.println(Calculate.sumOfAccount(account) + "€");
        // Read.sum(this.account);
        return 0;

    }
}