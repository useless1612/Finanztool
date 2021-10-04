package ase.finanzplaner.ui.tui;

import ase.finanzplaner.ui.UiController;

public class TuiController implements UiController {

    public Integer accDestroy(String account) {
        AccDestroy callable = new AccDestroy();
        return callable.call(account);
    }

    public Integer add(String account, String date, String amount, String description) {
        Add callable = new Add();
        return callable.call(account, date, amount, description);
    }

    public Integer delete(String account, Integer transactionId) {
        Delete callable = new Delete();
        return callable.call(account, transactionId);
    }

    public Integer overview(String account) {
        Overview callable = new Overview();
        return callable.call(account);
    }

    public Integer show(String account) {
        Show callable = new Show();
        return callable.call(account);
    }

    public Integer showAcc() {
        ShowAcc callable = new ShowAcc();
        return callable.call();
    }

    public Integer showDiff(String account) {
        ShowDiff callable = new ShowDiff();
        return callable.call(account);
    }

    public Integer sum(String account) {
        Sum callable = new Sum();
        return callable.call(account);
    }
}