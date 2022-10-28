import java.io.FileNotFoundException;

public class game {

    public static int num_sides_main;
    public static int num_dice_main;
    public static int rolls_per_hand_main;


    public static void main(String[] args) throws FileNotFoundException{
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
    
