package ase.finanzplaner.ui.tui;

import ase.finanzplaner.core.Write;

public class Add {
    public Integer call(String account, String date, String amount, String description) {
        System.out.printf("Called function call with account '%s' and transaction '%s %s %s'\n", account, date, amount, description);
        Write.add(account, date, amount, description);
        return 0;
    }
}