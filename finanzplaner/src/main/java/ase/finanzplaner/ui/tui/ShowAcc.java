package ase.finanzplaner.ui.tui;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import ase.finanzplaner.Read;
import picocli.CommandLine.Command;

@Command(name = "showacc", description = "Show all existing accounts")
public class ShowAcc implements Callable<Integer> {

    @Override
    public Integer call(){
        ArrayList<String> acclist = new ArrayList<String>();

        acclist = Read.showacc();

        for(int i = 0; i < acclist.size(); i++) {

            System.out.println("Account" + i + ": " + acclist.get(i));
        }
        return 0;

    }
}