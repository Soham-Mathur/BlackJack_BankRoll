public class Lose implements Bank{

    @Override
    public double moneyLeft(double balance, double bet){
        System.out.println("You LOST!!");
        return balance;
    }
//
}