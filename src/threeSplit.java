public class threeSplit {

    public double moneyLeft(double balance, double bet, int wins) {
        balance -= 2 * bet;
        switch (wins) {
            case 0 -> { System.out.println("\nYou LOST all of your hands!!");
                        return balance; }

            case 1 -> { System.out.println("\n1 WIN! & 2 LOSS!");
                        return balance + (2 * bet); }

            case 2 -> { System.out.println("\n2 WIN! & 1 LOSS!");
                        return balance + (4 * bet); }

            case 3 -> { System.out.println("\nYou WON all of your hands!!");
                        return balance + (6 * bet); }
        }
        return balance;
    }
//
}