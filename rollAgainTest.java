import static org.junit.Assert.assertEquals;
import org.junit.Test;



public class rollAgainTest {

    methods m = new methods();
    spock sp = new spock();
    file_io fl = new file_io();

    @Test

    public void testRollAgain() {
        int [] test = m.rollAgain();

        assertEquals(test, m.rollAgain());

    }
    
}
