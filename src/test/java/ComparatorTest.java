import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComparatorTest {
private Comparator comparator;
    @Before
    public void setUp(){
        comparator = new Comparator();
    }
    @Test
    public void generatorFilterTestIfTrue1() {
        assertEquals(3868, comparator.generatorFilter(65,8921));
    }
    @Test
    public void generatorFilterTestIfTrue2() {
    assertEquals(3926, comparator.generatorFilter(635,12));
    }
    @Test
    public void generatorFilterTestIfFalse() {
        assertNotEquals(6666, comparator.generatorFilter(635,12));
    }

}