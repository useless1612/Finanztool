package ase.finanzplaner.ui;

import java.util.concurrent.Callable;

import ase.finanzplaner.ui.exceptions.UnregisteredUiControllerException;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "showdiff", description = "Show all transactions and sum of account")
public class ShowDiff implements Callable<Integer> {

    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Override
    public Integer call() throws UnregisteredUiControllerException {
        UiController uiController = UiControllerProvider.getUiController();
        return uiController.showDiff(this.account);
    }

}


