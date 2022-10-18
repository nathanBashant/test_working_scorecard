import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestFirstTurn {
    
    methods m = new methods();

    @Test

    public void testFirstTurn(){
        m.firstTurn();
        assertEquals(1, m.firstTurn());
    }
}
