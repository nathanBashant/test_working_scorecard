import java.util.Scanner;

public class spock {

    public int num_sides;
    public int num_dice;
    public int rolls_per_hand;
    public Scanner scan = new Scanner(System.in);
    public char config_change;

    public int user_input_num_sides() {

        System.out.println("Enter 'y' if you would like to change the configuration");
        config_change = scan.next().charAt(0);

        if (config_change == 'y'){
            System.out.println("enter the number of sides on each die");
            num_sides = scan.nextInt();
        }

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
