import java.util.Random;

public class roll_the_dice {
    
    public Random rand = new Random();

    public int rollDice(){
        int die = rand.nextInt(6) + 1;
        return die;
    }
}
