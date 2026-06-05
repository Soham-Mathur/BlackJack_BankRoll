public class Push implements Bank{

    @Override
    public double moneyLeft(double balance, double bet){
        System.out.println("Tie!!");
        return balance + bet;
    }
//
}
