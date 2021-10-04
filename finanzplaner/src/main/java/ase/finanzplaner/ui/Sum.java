package ase.finanzplaner.ui;

import java.util.concurrent.Callable;

import ase.finanzplaner.ui.exceptions.UnregisteredUiControllerException;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "sum", description = "Summarize account")
public class Sum implements Callable<Integer> {
    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Override
    public Integer call() throws UnregisteredUiControllerException{
        UiController uiController = UiControllerProvider.getUiController();
        return uiController.sum(this.account);

    }
}