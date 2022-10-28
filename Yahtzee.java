/* done repo */
import java.util.Scanner;
import java.util.Random;

/**
* This program plays the game of Yahtzee through the terminal
* CPSC 224-01, Fall 2022
* Programming Assignment #3
* No sources to cite.
* 
* @author Nathan Bashant
* @version v2.1 10/15/22
*/


public class Yahtzee {

    public Scanner scan = new Scanner(System.in);
    public Random rand = new Random();
    methods m = new methods();

    /* Scorecard */

    public void run (){
        do {

            m.firstTurn();

            while (m.rollPerTurn < m.rolls_per_hand){

                System.out.println("enter dice to keep (y or n), on the next line, press 'S' for scorecard or any key to continue");

                m.keep = scan.next();
                m.new_keep = scan.next().charAt(0);

                if (m.new_keep == 'S'){
                    m.print_scorecard();
                    System.out.println("Please re-enter your dice to keep (y or n)");
                    System.out.print("Your roll currently: " );
                    for(int i = 0; i < m.dice.length; i++){
                        System.out.print(m.dice[i] + " ");
                    }
                    System.out.println();
                }
                else{
                    m.rollAgain();
                }
            }

            System.out.println("Here is your sorted hand: ");
            m.sortArray(m.dice);
            System.out.println();

            for (int dieValue = 1; dieValue <= m.num_sides; dieValue++){
                int currentCount = 0;
                for (int diePosition = 0; diePosition < m.num_dice; diePosition++){
                    if (m.dice[diePosition] == dieValue)
                        currentCount++;
                }
                System.out.println("Score: " + dieValue * currentCount + " on the " + dieValue + " line "); 
            }

            if (m.maxOfAKindFound(m.dice) >= 3){
                System.out.println("Score " + m.totalAllDice(m.dice) + " on the 3 of a Kind line");
            }

            else{
                System.out.println("Score 0 on the 3 of a Kind line");
            }

            if (m.maxOfAKindFound(m.dice) >= 4){
                System.out.println("Score " + m.totalAllDice(m.dice) + " on the 4 of a Kind line"); 
            }

            else{
               System.out.println("Score 0 on the 4 of a Kind line");
            }

            if (m.fullHouseFound(m.dice)){
                System.out.println("Score 25 on the Full House line");
            }
            else{
                System.out.println("Score 0 on the Full House line");
            }

            if (m.maxStraightFound(m.dice) >= 4){
                System.out.println("Score 30 on the Small Straight line");
            }
            else{
                System.out.println("Score 0 on the Small Straight line");
            }

            if (m.maxStraightFound(m.dice) >= 5){
                System.out.println("Score 40 on the Large Straight line");
            }
            else{
                System.out.println("Score 0 on the Large Straight line");
            }

            if (m.maxOfAKindFound(m.dice) >= 5){
                System.out.println("Score 50 on the Yahtzee line");
            }
            else{
                System.out.println("Score 0 on the Yahtzee line");
            }
            System.out.println("Scorecard:");
            System.out.println();
            m.print_scorecard();
            System.out.println();
            System.out.println("Enter 'y' to play again or any key to stop");
            m.playAgain = scan.next().charAt(0);
        
    } while (m.rollPerTurn >= m.rolls_per_hand && m.playAgain == 'y');
    System.out.println("Thank you for playing! ");
}

}

