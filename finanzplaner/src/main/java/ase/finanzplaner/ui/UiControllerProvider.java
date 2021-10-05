package ase.finanzplaner.ui;

import ase.finanzplaner.ui.exceptions.UnregisteredUiControllerException;

public class UiControllerProvider {

    private static UiControllerProvider uiControllerProvider = null;

    private UiController uiController = null;

    public static void registerUiController(UiController uiController) {
        UiControllerProvider.uiControllerProvider = new UiControllerProvider(uiController);
    }

    public static UiController getUiController() throws UnregisteredUiControllerException {
        if (uiControllerProvider == null || uiControllerProvider.getCurrentUiController() == null) {
            throw new UnregisteredUiControllerException();
        }
        return UiControllerProvider.uiControllerProvider.getCurrentUiController();
    }

    private UiControllerProvider(UiController uiController) {
        this.uiController = uiController;
    }

    public UiController getCurrentUiController() {
        return this.uiController;
    }
}