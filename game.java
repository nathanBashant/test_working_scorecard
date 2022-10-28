/*
COMMENT BLOCK FOR ENTIRE CLASS
# Programmer: Nathan Bashant-Coon
# Class: CptS 224, Fall 2022
# Homework Assignment #4
# 10/20/22
# 
# Class Description: main game execution that takes file input from file, user input, and uses Yahtzee class
# for main functionality. 
*/

import java.io.IOException;

public class game {

    public static int num_sides_main;
    public static int num_dice_main;
    public static int rolls_per_hand_main;


    public static void main(String[] args) throws IOException {
        spock sp = new spock();
        file_io fl = new file_io();
        
        fl.read_sides();

        num_sides_main = sp.user_input_num_sides();
        num_dice_main = sp.user_input_num_dice();
        rolls_per_hand_main = sp.user_input_rolls_hand();

        Yahtzee game = new Yahtzee();
        game.run();

    }
}
    
