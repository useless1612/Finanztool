package ase.finanzplaner.ui.tui;

import java.util.concurrent.Callable;

import ase.finanzplaner.Read;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "sum", description = "Summarize account")
public class Sum implements Callable<Integer> {
    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Override
    public Integer call(){
        
        System.out.println(Read.sum(this.account) + "€");
        // Read.sum(this.account);
        return 0;

    }
}