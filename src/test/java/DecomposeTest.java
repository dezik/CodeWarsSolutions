import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by:
 *
 * @author Dmytro Shablia
 * @since 06.02.2018
 */
public class DecomposeTest {
    @Test
    public void test1() {
        Decompose d = new Decompose();
        long n = 11;
        assertEquals("1 2 4 10",  d.decompose(n));
    }

    @Test
    public void test2() {
        Decompose d = new Decompose();
        long n = 50;
        assertEquals("1 3 5 8 49",  d.decompose(n));
    }

    @Test
    public void test3() {
        Decompose d = new Decompose();
        long n = 10;
        assertEquals("6 8",  d.decompose(n));
    }

    @Test
    public void test4() {
        Decompose d = new Decompose();
        long n = 12;
        assertEquals("1 2 3 7 9",  d.decompose(n));
    }
    @Test
    public void test5() {
        Decompose d = new Decompose();
        long n = 100000;
        assertEquals("1 2 4 13 447 99999",  d.decompose(n));
    }

}