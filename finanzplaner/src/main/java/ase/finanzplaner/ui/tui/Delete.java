package ase.finanzplaner.ui.tui;

import java.util.concurrent.Callable;

import ase.finanzplaner.DeleteLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "delete", description = "Delete transaction with tansaction id from given account")
public class Delete implements Callable<Integer> {
    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Option(names = { "-i", "--id" }, required = true, description = "Specify ID of target transaction")
    Integer transactionId;

    @Override 
    public Integer call() {
        System.out.printf("Called function call with account '%s' and transaction-ID '%s'\n", this.account, this.transactionId);
        DeleteLine.deleterow(this.account, this.transactionId);
        return 0;
    }
}