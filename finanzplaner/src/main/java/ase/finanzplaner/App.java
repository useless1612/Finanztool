package ase.finanzplaner;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import ase.finanzplaner.ui.tui.*;

/**
 * Hello world!
 *
 */
@Command(name = "fz", mixinStandardHelpOptions = true, version = "0.0.1", description="finanztool (fz): because who wouldn't want to handle ones finances on the command line?", subcommands = {
    Add.class,
    Delete.class,
    Show.class,
    Sum.class,
    AccDestroy.class,
    ShowDiff.class,
    ShowAcc.class,
    Overview.class,
})
public class App {
    public static void main( String[] args ) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
