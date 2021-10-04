package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.Read;

public class Show {

    public Integer call(String account){
        
        Read.show(account);
        return 0;

    }
}