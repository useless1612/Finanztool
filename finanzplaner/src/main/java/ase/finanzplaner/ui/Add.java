package ase.finanzplaner.ui;

import java.util.concurrent.Callable;

import ase.finanzplaner.ui.exceptions.UnregisteredUiControllerException;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "add", description = "Add transaction to given account")
public class Add implements Callable<Integer>{

    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Parameters(paramLabel = "date")
    String date;

    @Parameters(paramLabel = "amount")
    String amount;

    @Parameters(paramLabel = "description")
    String description;

    @Override 
    public Integer call() throws UnregisteredUiControllerException {
        UiController uiController = UiControllerProvider.getUiController();
        return uiController.add(this.account, this.date, this.amount, this.description);
    }
}