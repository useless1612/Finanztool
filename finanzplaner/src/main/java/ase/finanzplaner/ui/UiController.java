package ase.finanzplaner.ui;

public interface UiController {

    public Integer accDestroy(String account);
    public Integer add(String account, String date, String amount, String description);
    public Integer delete(String account, Integer transactionId);
    public Integer overview(String account);
    public Integer show(String account);
    public Integer showAcc();
    public Integer showDiff(String account);
    public Integer sum(String account);

}