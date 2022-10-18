import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class DiceRollTest {
    
    methods m = new methods();
    spock sp = new spock();
    file_io fl = new file_io();

    @Test

    public void testDiceRoll() {
        int [] dice = m.dice;

        for(int i = 0; i < dice.length; i++){
            dice[i] = m.rollDice();
        }
        
        assertEquals(dice, dice);
    }

}