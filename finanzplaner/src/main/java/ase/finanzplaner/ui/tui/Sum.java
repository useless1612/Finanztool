package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.Read;

public class Sum {

    public Integer call(String account){
        
        System.out.println(Read.sum(account) + "€");
        // Read.sum(this.account);
        return 0;

    }
}