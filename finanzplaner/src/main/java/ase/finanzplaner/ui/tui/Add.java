package ase.finanzplaner.ui.tui;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "add", description = "Add transaction to given account")
public class Add implements Callable<Integer>{

    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Parameters(paramLabel = "date")
    String date;

    @Parameters(paramLabel = "amount")
    String amount;

    @Parameters(paramLabel = "description")
    String description;

    @Override 
    public Integer call() {
        System.out.printf("Called function call with account '%s' and transaction '%s %s %s'\n", this.account, this.date, this.amount, this.description);
        return 0;
    }
}