package ase.finanzplaner.ui.tui;

import java.util.ArrayList;

import ase.finanzplaner.core.Read;

public class ShowAcc {

    public Integer call(){
        ArrayList<String> acclist = new ArrayList<String>();

        acclist = Read.showacc();

        for(int i = 0; i < acclist.size(); i++) {

            System.out.println("Account" + i + ": " + acclist.get(i));
        }
        return 0;

    }
}