import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static void main() throws InterruptedException {

//DECLARATION
        Win win = new Win();
        Lose lose = new Lose();
        Push push = new Push();
        blackJack blackjack = new blackJack();
        doubleDown doubleDown = new doubleDown();
        twoSplit twosplit = new twoSplit();
        threeSplit threesplit = new threeSplit();

        double startingBalance;
        double bet;
        int event;
        String playAgain;
        double totalWin =0;
        double total = 0;

//ENTER STARTING BALANCE
        System.out.print("Please enter your starting balance: ");
        while (true) {

            if (scanner.hasNextDouble()) {
                startingBalance = scanner.nextDouble();

                if (startingBalance > 0 && startingBalance <= 2100000000) {
                    break;      // valid input, exit loop
                }
                else if(startingBalance<=0) {
                    System.out.println("**Your starting balance CANNOT be 0 OR less**");
                }
                else{
                    System.out.println("**Your starting balance CANNOT be greater than 2.1 Billion**");
                }

            } else {
                System.out.println("**Invalid Input!!**");
                scanner.nextLine();     //Eats up leftovers
            }
            System.out.print("\nPlease enter your starting balance: ");
        }

        System.out.println();

        double finalBalance = startingBalance;

//LOOP START
        do {

//CHECK YOUR BET


            System.out.print("How much are you willing to bet: ");

            while (true) {

                if (scanner.hasNextDouble()) {
                    bet = scanner.nextDouble();

                    if (bet <= finalBalance && bet > 0) {
                        break;      // valid input, exit loop
                    } else if (bet <= 0) {
                        System.out.println("**Your Bet CANNOT be 0 OR Less!!**");
                    } else if (bet > finalBalance) {
                        System.out.println("**Your Bet CAN NOT be Larger than your balance!!**");
                    }
                } else {
                    System.out.println("**Invalid Input!!**");
                    scanner.nextLine();     //Eats up leftovers
                }
                System.out.print("\nHow much are you willing to bet: ");
            }

            finalBalance -= bet;

//CHECK WIN OR LOSE
            do {
                System.out.print("""
                        
                        What event occurred:
                        1. Win
                        2. Lose
                        3. Push
                        4. Blackjack
                        5. Double
                        6. Two Split
                        7. Three Split
                        8. Exit
                        Enter the Number---->""");
                if(scanner.hasNextInt()) {
                    event = scanner.nextInt();
                }else{
                    System.out.println("**Invalid Input!!**");
                    scanner.nextLine();     //Eat up leftovers
                    event = -1;      //Invalid code and forces do-While loop
                    continue;
                }

                if (event < 1 || event > 8) {
                    System.out.println("**Please enter a Valid Input!!**");
                } else if (event == 5 && finalBalance < bet) {
                    System.out.println("\n**You don't have enough Balance to Double Down!!**");
                } else if (event == 6 && finalBalance < bet) {
                    System.out.println("\n**You don't have enough Balance to Two Split!!**");
                } else if (event == 7 && finalBalance < 2 * bet) {
                    System.out.println("\n**You don't have enough Balance to Three Split!!**");
                }

            } while (   event == 5 && finalBalance < bet
                    ||  event == 6 && finalBalance < bet
                    ||  event == 7 && finalBalance < 2 * bet
                    ||!(event > 0 && event < 9));

            System.out.println();     //Skips line for cleanliness

//EVENT APPLICATION
            switch (event) {
                case 1 -> {
                    finalBalance = win.moneyLeft(finalBalance, bet);
                    totalWin++;
                    scanner.nextLine();     //Eat up leftovers
                }

                case 2 -> {
                    finalBalance = lose.moneyLeft(finalBalance, bet);
                    scanner.nextLine();     //Eat up leftovers
                }

                case 3 -> {
                    total--;
                    finalBalance = push.moneyLeft(finalBalance, bet);
                    scanner.nextLine();     //Eat up leftovers
                }

                case 4 -> {
                    finalBalance = blackjack.moneyLeft(finalBalance, bet);
                    totalWin++;
                    scanner.nextLine();     //Eat up leftovers
                }

                case 5 -> {
                    double before = finalBalance;
                    finalBalance = doubleDown.moneyLeft(finalBalance, bet);
                    if (finalBalance > before) totalWin++;
                }


                case 6 -> {
                    while (true) {
                        System.out.print("How many hands did you win(0,1,2): ");
                        if (scanner.hasNextInt()) {
                            int splitWins = scanner.nextInt();

                            if (splitWins >= 0 && splitWins <= 2) {
                                total++;
                                totalWin += splitWins;
                                finalBalance = twosplit.moneyLeft(finalBalance, bet, splitWins);
                                scanner.nextLine();   //Eat up leftovers
                                break;   //valid input, exit loop
                            } else {
                                System.out.println("**Input has to be Between 0 and 2!!**");
                                System.out.println();     //Skips line for cleanliness
                            }
                        } else {
                            System.out.println("**Invalid Input!!**");
                            scanner.nextLine();   //Eat up leftovers
                            System.out.println();     //Skips line for cleanliness
                        }
                    }
                }

                case 7 -> {
                    while (true) {
                        System.out.print("How many hands did you win(0,1,2,3): ");
                        if (scanner.hasNextInt()) {
                            int splitWins = scanner.nextInt();

                            if (splitWins >= 0 && splitWins <= 3) {
                                total +=2 ;
                                totalWin += splitWins;
                                finalBalance = threesplit.moneyLeft(finalBalance, bet, splitWins);
                                scanner.nextLine();     //Eat up leftovers
                                break;
                            } else {
                                System.out.println("**Input has to be between 0 and 3!!**");
                                System.out.println();     //Skips line for cleanliness
                            }
                        } else {
                            System.out.println("**Invalid Input!!**");
                            scanner.nextLine();     //Eat up leftovers
                            System.out.println();     //Skips line for cleanliness
                        }
                    }
                }
                case 8 -> {
                    finalBalance += bet;
                    playAgain = "n";
                    continue;
                }
            }
//SHOW BALANCE
                System.out.println("\n*********************************");
                System.out.printf("Your current balance is %,.2f$", finalBalance);
                System.out.println("\n*********************************");

//LOOP
                do {
                    if (finalBalance == 0) {
                        System.out.print("\n**You CAN NOT proceed further due to 0 money in balance!!**");
                        playAgain = "n";
                        break;
                    } else {
                        System.out.print("\nDo you want to play again(y/n): ");
                        playAgain = scanner.nextLine();

                        if (!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n")) {
                            System.out.println("**Please enter a Valid Input!!**");
                        }
                    }

                } while (!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n"));

                total++;
                System.out.println();     //Skips line for cleanliness

            }
            while (playAgain.equalsIgnoreCase("y")) ;


//FINAL PROFIT/LOSE & WIN%
        if (total > 0) {
            System.out.printf("\nYour final balance comes out to %,.2f$", finalBalance);
            System.out.println("\nAnd your profit was.....");
            //1
            Thread.sleep(550);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            //2
            Thread.sleep(550);
            System.out.print("\n.");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            //3
            Thread.sleep(550);
            System.out.print("\n.");
            Thread.sleep(550);
            System.out.print(".");
            Thread.sleep(800);

            System.out.println("\n\n**********************************************************");
            double net = finalBalance - startingBalance;
            System.out.printf("Your total Profit/Loss came up to... %,.2f$", net);
            double percentage = (totalWin / total) * 100;
            System.out.printf("\nAnd your win percentage was... %.2f%%", percentage);
            System.out.println("\n**********************************************************");
            System.out.print("\nThank you for using BlackJack_BankRoll!! :)");
        }else{
            System.out.print("Thank you for using BlackJack_BankRoll!! :)");
        }

            scanner.close();
//END
        }
}