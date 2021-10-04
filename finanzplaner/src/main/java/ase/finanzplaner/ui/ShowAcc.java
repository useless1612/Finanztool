package ase.finanzplaner.ui;

import java.util.concurrent.Callable;

import ase.finanzplaner.ui.exceptions.UnregisteredUiControllerException;
import picocli.CommandLine.Command;

@Command(name = "showacc", description = "Show all existing accounts")
public class ShowAcc implements Callable<Integer> {

    @Override
    public Integer call() throws UnregisteredUiControllerException{
        UiController uiController = UiControllerProvider.getUiController();
        return uiController.showAcc();
    }
}