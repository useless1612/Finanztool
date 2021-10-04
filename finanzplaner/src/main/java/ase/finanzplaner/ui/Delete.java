package ase.finanzplaner.ui;

import java.util.concurrent.Callable;

import ase.finanzplaner.ui.exceptions.UnregisteredUiControllerException;
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
    public Integer call() throws UnregisteredUiControllerException {
        UiController uiController = UiControllerProvider.getUiController();
        return uiController.delete(this.account, this.transactionId);
    }
}