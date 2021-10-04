package ase.finanzplaner;

public class Overviewwrapper {

    public static void overview(String account){

        Read.show(account);
        ResultForDiff result = Read.showdiff(account);
        
        System.out.println( "your incomes amount to: " + result.getFirst().toString() + "€");

        System.out.println("your spendings amount to: " + result.getSecond().toString() + "€");

        System.out.println("your account balance is: " + Read.sum(account) + "€");




    }
    
}
