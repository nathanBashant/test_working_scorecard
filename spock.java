/*
COMMENT BLOCK FOR ENTIRE CLASS
# Programmer: Nathan Bashant-Coon
# Class: CptS 224, Fall 2022
# Homework Assignment #4
# 10/20/22
# 
# Class Description: mostly the entire implementation of lizrd spock yahztzee, if the uzer decides to change the dice
# configuration, this is what the program uses
*/


import java.util.Scanner;

public class spock {

    public int num_sides;
    public int num_dice;
    public int rolls_per_hand;
    public Scanner scan = new Scanner(System.in);
    public char config_change;

    file_io fio = new file_io();

    public void no_change(){
        System.out.println("You are playing with " + fio.num_dice_txt + " " + fio.num_sides_txt + "-sided dice"); 
        System.out.println("You get " + fio.num_rolls_txt + " rolls per hand"); 
    }

    public int user_input_num_sides() {

        System.out.println("Enter 'y' if you would like to change the configuration or 'n' to keep current configuration");
        config_change = scan.next().charAt(0);

        if (config_change == 'y'){
            System.out.println("enter the number of sides on each die");
            num_sides = scan.nextInt();
        }
        /*
        else if (config_change == 'n'){
            no_change();
        }
        */

        return num_sides;
    }

    public int user_input_num_dice() {
        if (config_change == 'y'){
            System.out.println("enter the number of dice in play");
            num_dice = scan.nextInt();
        }

        return num_dice;
    }

    public int user_input_rolls_hand() {
        if (config_change == 'y'){
            System.out.println("enter the number of rolls per hand");
            rolls_per_hand = scan.nextInt();
        }

        return rolls_per_hand;
    }
    
}
