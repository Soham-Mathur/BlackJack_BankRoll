public class Win implements Bank{

    @Override
    public double moneyLeft(double balance, double bet){
        System.out.println("You WON!!");
        return balance + 2 * bet;
    }
//
}