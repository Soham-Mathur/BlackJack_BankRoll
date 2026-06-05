public class doubleDown implements Bank{

    @Override
    public double moneyLeft(double balance, double bet) {

        String winLose;
        balance -= bet;

        Main.scanner.nextLine();    //Eat up leftovers

        do {
            System.out.print("Did you win your Double(W/L): ");
            winLose = Main.scanner.nextLine();
            if (!winLose.equalsIgnoreCase("W") && !winLose.equalsIgnoreCase("L")) {
                System.out.println("Invalid input");
            } else {
                if (winLose.equalsIgnoreCase("W")) {
                    System.out.println("\nYou WON!!");
                    return balance + 4 * bet;
                } else {
                    System.out.println("\nYou LOST!!");
                    return balance;
                }
            }
            System.out.println();

        }while(!winLose.equalsIgnoreCase("W") && !winLose.equalsIgnoreCase("L"));
        return balance;
    }
//
}
