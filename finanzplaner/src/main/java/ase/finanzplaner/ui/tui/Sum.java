package ase.finanzplaner.ui.tui;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "sum", description = "Summarize account")
public class Sum {
    @Parameters(paramLabel = "ACCOUNT")
    String account;
}