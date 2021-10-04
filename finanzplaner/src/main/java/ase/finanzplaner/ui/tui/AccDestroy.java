package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.DeleteLine;

public class AccDestroy {

    public Integer call(String account) {
        System.out.printf("Called function call with account '%s'\n", account);
        DeleteLine.accdestroy(account);
        return 0;
    }
}