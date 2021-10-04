package ase.finanzplaner.ui.tui;

import java.util.concurrent.Callable;

import ase.finanzplaner.DeleteLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "accdestroy", description = "Delete a complete account")
public class AccDestroy implements Callable<Integer> {
    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Override 
    public Integer call() {
        System.out.printf("Called function call with account '%s'\n", this.account);
        DeleteLine.accdestroy(this.account);
        return 0;
    }

}

