package ase.finanzplaner.ui.tui;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "show", description = "Show all transactions and sum of account")
public class Show {
    @Parameters(paramLabel = "ACCOUNT")
    String account;
}