package ase.finanzplaner.ui.tui;

import java.util.concurrent.Callable;

import ase.finanzplaner.Read;
import ase.finanzplaner.ResultForDiff;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "showdiff", description = "Show all transactions and sum of account")
public class ShowDiff implements Callable<Integer> {

    @Parameters(paramLabel = "ACCOUNT")
    String account;

    @Override
    public Integer call(){
        ResultForDiff result = Read.showdiff(this.account);
        
        System.out.println( "your incomes amount to: " + result.getFirst().toString() + "€");

        System.out.println("your spendings amount to: " + result.getSecond().toString() + "€");

        System.out.println("your account balance is: " + Read.sum(this.account) + "€");

        
        
        return 0;

    }

}


