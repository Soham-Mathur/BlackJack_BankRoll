public class twoSplit {

    public double moneyLeft(double balance, double bet, int wins) {
        balance -= bet;
        switch (wins) {
            case 0 -> { System.out.println("\nYou LOST both of your hands!!");
                        return balance;}

            case 1 -> { System.out.println("\n1 WIN! & 1 LOSS!");
                        return balance + (2 * bet); }

            case 2 -> { System.out.println("\nYou WON both of your hands!!");
                        return balance + (4 * bet); }
        }
        return balance;
    }
//
}