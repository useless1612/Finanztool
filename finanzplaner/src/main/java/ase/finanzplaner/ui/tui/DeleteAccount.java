package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.DeleteOperations;

public class DeleteAccount {

    public Integer call(String account) {
        System.out.printf("Called function call with account '%s'\n", account);
        DeleteOperations.deleteAccount(account);
        return 0;
    }
}