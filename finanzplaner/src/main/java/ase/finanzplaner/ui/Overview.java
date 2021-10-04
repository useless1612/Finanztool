package ase.finanzplaner.ui;

import java.util.concurrent.Callable;

import ase.finanzplaner.ui.exceptions.UnregisteredUiControllerException;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "overview", description = "Gives an Overview over an existing Account")
public class Overview implements Callable<Integer> {
    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Override
    public Integer call() throws UnregisteredUiControllerException {
        UiController uiController = UiControllerProvider.getUiController();
        return uiController.overview(this.account);
    }
}