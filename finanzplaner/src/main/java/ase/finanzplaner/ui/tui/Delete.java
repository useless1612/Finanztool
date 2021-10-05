package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.DeleteOperations;

public class Delete {

    public Integer call(String account, Integer transactionId) {
        System.out.printf("Called function call with account '%s' and transaction-ID '%s'\n", account, transactionId);
        DeleteOperations.deleteline(account, transactionId);
        return 0;
    }
}