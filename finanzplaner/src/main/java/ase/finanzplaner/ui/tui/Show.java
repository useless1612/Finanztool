package ase.finanzplaner.ui.tui;

import java.util.concurrent.Callable;

import ase.finanzplaner.Read;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "show", description = "Show all transactions and sum of account")
public class Show implements Callable<Integer> {
    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Override
    public Integer call(){
        
        Read.show(this.account);
        return 0;

    }
}