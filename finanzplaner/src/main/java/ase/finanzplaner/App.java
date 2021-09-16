package ase.finanzplaner;

import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import ase.finanzplaner.ui.tui.*;

/**
 * Hello world!
 *
 */
@Command(name = "fz", mixinStandardHelpOptions = true, version = "0.0.1", description="Whatever", subcommands = {
    Add.class,
    Delete.class,
    Show.class,
    Sum.class,
})
public class App {
    public static void main( String[] args ) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
