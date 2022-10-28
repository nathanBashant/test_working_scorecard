
/*
COMMENT BLOCK FOR ENTIRE CLASS
# Programmer: Nathan Bashant-Coon
# Class: CptS 224, Fall 2022
# Homework Assignment #4
# 10/20/22
# 
# Class Description: methods that are used in the Yahtzee class when executing the main game
*/


import java.util.Scanner;

import java.util.Random;


public class methods {

    game g = new game();

    public Scanner scan = new Scanner(System.in);

    public int num_sides = g.num_sides_main;
    public int num_dice = g.num_dice_main;
    public int rolls_per_hand = g.rolls_per_hand_main;

    public int [] dice = new int [num_dice];

    public int rollPerTurn;
    public char playAgain = 'y';
    public String keep = "nnnnn";
    public char new_keep = 'S';
    public final int TOT_DICE = num_dice;
    public Random rand = new Random();
    
    public int rollDice(){
        int die = rand.nextInt(num_sides) + 1;
        return die;
    }
    

    public int maxOfAKindFound(int dice[]){
        int maxCount = 0;
        int currentCount = 0;
        
        for (int dieValue = 1; dieValue <= num_sides; dieValue++){
            currentCount = 0;
            for (int diePosition = 0; diePosition < num_dice; diePosition++){
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
        int countactive = num_dice - 2;
        for(int counter = 0; counter < countactive; counter++){
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
        for (int dieValue = 1; dieValue <= num_sides; dieValue++){
            currentCount = 0;
            for (int diePosition = 0; diePosition < num_dice; diePosition++){
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
        for (int diePosition = 0; diePosition < num_dice; diePosition++){
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


    public int firstTurn(){

        System.out.println("number of sides: " + num_sides);
        System.out.println("number of dice: " + num_dice);
        System.out.println("number of rolls per hand: " + rolls_per_hand);
        
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

    public void print_scorecard(){
        sortArray(dice);
        System.out.println();

        System.out.println("Line        Score");
        System.out.println("------------------");
        int subtotal_score = 0;
        int bonus = 0;
        int upper_total = 0;
        int tofk = 0;
        int fofk = 0;
        int fh = 0;
        int ss = 0;
        int ls = 0;
        int yaht = 0;
        int chance = 0;
        int lower_total = 0;


        for (int dieValue = 1; dieValue <= num_sides; dieValue++){
            int currentCount = 0;
            for (int diePosition = 0; diePosition < num_dice; diePosition++){
                if (dice[diePosition] == dieValue)
                    currentCount++;
            }
            int die_score = dieValue * currentCount;
            System.out.println(dieValue + "              " + die_score); 
            subtotal_score = subtotal_score + die_score;
        }

        if (subtotal_score >= 63){
            bonus = 35;
        }

        upper_total = subtotal_score + bonus;

        System.out.println("------------------");
        System.out.println("Sub Total     " + subtotal_score);
        System.out.println("Bonus         " + bonus);
        System.out.println("Upper Total    " + upper_total);
        System.out.println("------------------");

        if (maxOfAKindFound(dice) >= 3){
            tofk = totalAllDice(dice);
        }

        if (maxOfAKindFound(dice) >= 4){
            fofk = totalAllDice(dice);
        }

        if (fullHouseFound(dice)){
            fh = 35;
        }

        if (maxStraightFound(dice) >= 4){
            ss = 30;
        }
        if (maxStraightFound(dice) >= 5){
            ls = 40;
        }
       
        if (maxOfAKindFound(dice) >= 5){
            yaht = 50;
        }

        chance = subtotal_score;
        lower_total = tofk + fofk + fh + ss + ls + yaht + chance;

        System.out.println("3 of a Kind     " + tofk);
        System.out.println("4 of a Kind     " + fofk);
        System.out.println("Full House      " + fh);
        System.out.println("Small Straight  " + ss);
        System.out.println("Large Straight  " + ls);
        System.out.println("Yahtzee         " + yaht);
        System.out.println("Chance          " + chance);
        System.out.println("------------------");
        System.out.println("Lower Total:    " + lower_total);


    }


    
}
