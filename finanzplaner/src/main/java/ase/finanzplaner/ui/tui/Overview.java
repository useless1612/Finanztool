package ase.finanzplaner.ui.tui;

import java.util.concurrent.Callable;

import ase.finanzplaner.Overviewwrapper;
import ase.finanzplaner.Read;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "overview", description = "Gives an Overview over an existing Account")
public class Overview implements Callable<Integer> {
    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Override
    public Integer call(){
        
        Overviewwrapper.overview(this.account);
        return 0;

    }
}