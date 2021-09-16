package ase.finanzplaner.ui.tui;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "delete", description = "Delete transaction with tansaction id from given account")
public class Delete {
    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Option(names = { "-i", "--id" }, required = true, description = "Specify ID of target transaction")
    Integer transactionId;
}