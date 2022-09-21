/* done repo */
import java.util.Scanner;
import java.util.Random;

/**
* This program plays the game of Yahtzee through the terminal
* CPSC 224-01, Fall 2022
* Programming Assignment #2
* No sources to cite.
* 
* @author Nathan Bashant
* @version v1.1 9/20/22
*/



public class Yahtzee {
    
    private int [] dice = new int [5];
    public Scanner scan = new Scanner(System.in);
    public Random rand = new Random();
    public int rollPerTurn;
    public char playAgain = 'y';
    public String keep = "nnnnn";
    private final int TOT_DICE = 5;
    roll_the_dice rollDice = new roll_the_dice();
    

    public int maxOfAKindFound(int dice[]){
        int maxCount = 0;
        int currentCount ;
        for (int dieValue = 1; dieValue <=6; dieValue++){
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++){
                if (dice[diePosition] == dieValue){
                    currentCount++;
                }
            }
            if (currentCount > maxCount){
                maxCount = currentCount;
            }
        }
        return maxCount;
    }

    public int maxStraightFound(int dice[]){
        int maxLength = 1;
        int curLength = 1;
        for(int counter = 0; counter < 4; counter++){
            if (dice[counter] + 1 == dice[counter + 1] ) //jump of 1
            curLength++;
        else if (dice[counter] + 1 < dice[counter + 1]) //jump of >= 2
            curLength = 1;
        if (curLength > maxLength)
            maxLength = curLength;
    }
    return maxLength;
    }

    public boolean fullHouseFound(int dice[]){
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount ;
        for (int dieValue = 1; dieValue <=6; dieValue++){
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++){
                if (dice[diePosition] == dieValue){
                currentCount++;
                }
            }
        if (currentCount == 2){
            found2K = true;
        }
        if (currentCount == 3){
            found3K = true;
        }
    }
        if (found2K && found3K){
            foundFH = true;
        }
    return foundFH;
    }

    public int totalAllDice(int dice[]){
        int total = 0;
        for (int diePosition = 0; diePosition < 5; diePosition++){
            total += dice[diePosition];
        }
    return total;
    }

    public void sortArray(int array[]){
        boolean swap;
        int temp;

        do{
            swap = false;
            for (int count = 0; count < (TOT_DICE - 1); count++){
                if (array[count] > array[count + 1]){
                    temp = array[count];
                    array[count] = array[count + 1];
                    array[count + 1] = temp;
                    swap = true;
                }
            }
        } while (swap);
        for (int i = 0; i < TOT_DICE; i++){
            System.out.print(dice[i] + " ");
        }
    }


    public int rollDice(){
        int die = rand.nextInt(6) + 1;
        return die;
    }

    public int firstTurn(){
        for(int i = 0; i < dice.length; i++){
            dice[i] = rollDice();
        }
        System.out.print("Your roll was: " );
        for(int i = 0; i < dice.length; i++){
            System.out.print(dice[i] + " ");
        }
        System.out.println();
        rollPerTurn = 1;
        return rollPerTurn;
    }

    public int [] rollAgain(){

        for (int i = 0; i < dice.length; i++){
            if (keep.charAt(i) != 'y'){
                dice[i] = rollDice();
            }
        }
        rollPerTurn++;

        System.out.print("Your roll was: " );
        for(int i = 0; i < dice.length; i++){
            System.out.print(dice[i] + " ");
        }
        System.out.println();
        return dice;

    }

    /* Scorecard */

    public void run (){
        do {

            firstTurn();

            while (rollPerTurn < 3){

                System.out.println("enter dice to keep (y or n) ");

                keep = scan.next();

                rollAgain();
            }

            System.out.println("Here is your sorted hand: ");
            sortArray(dice);
            System.out.println();

            for (int dieValue = 1; dieValue <=6; dieValue++){
                int currentCount = 0;
                for (int diePosition = 0; diePosition < 5; diePosition++){
                    if (dice[diePosition] == dieValue)
                        currentCount++;
                }
                System.out.println("Score: " + dieValue * currentCount + " on the " + dieValue + " line "); 
            }

            if (maxOfAKindFound(dice) >= 3){
                System.out.println("Score " + totalAllDice(dice) + " on the 3 of a Kind line");
            }
            else{
                System.out.println("Score 0 on the 3 of a Kind line");
            }

            if (maxOfAKindFound(dice) >= 4){
                System.out.println("Score " + totalAllDice(dice) + " on the 4 of a Kind line"); 
            }
            else{
               System.out.println("Score 0 on the 4 of a Kind line");
            }

            if (fullHouseFound(dice)){
                System.out.println("Score 25 on the Full House line");
            }
            else{
                System.out.println("Score 0 on the Full House line");
            }

            if (maxStraightFound(dice) >= 4){
                System.out.println("Score 30 on the Small Straight line");
            }
            else{
                System.out.println("Score 0 on the Small Straight line");
            }

            if (maxStraightFound(dice) >= 5){
                System.out.println("Score 40 on the Large Straight line");
            }
            else{
                System.out.println("Score 0 on the Large Straight line");
            }

            if (maxOfAKindFound(dice) >= 5){
                System.out.println("Score 50 on the Yahtzee line");
            }
            else{
                System.out.println("Score 0 on the Yahtzee line");
            }

            System.out.println();
            System.out.println("Enter 'y' to play again or any key to stop");
            playAgain = scan.next().charAt(0);
        
    } while (rollPerTurn >= 3 && playAgain == 'y');
    System.out.println("Thank you for playing! ");
}

}

