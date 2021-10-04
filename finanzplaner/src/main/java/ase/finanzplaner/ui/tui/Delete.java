package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.DeleteLine;

public class Delete {

    public Integer call(String account, Integer transactionId) {
        System.out.printf("Called function call with account '%s' and transaction-ID '%s'\n", account, transactionId);
        DeleteLine.deleterow(account, transactionId);
        return 0;
    }
}