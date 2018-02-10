import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

import static java.lang.Math.*;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        for (int i = 2; i <= ceil(sqrt(n)); i++) {
            for (int j = 2; pow(i,j) <= n; j++) {
                if (n == pow(i, j)) return new int[] {i,j};
                if (n == pow(j, i)) return new int[] {j,i};
            }
        }
        return null;
    }


    @Test
    public void test0() {
        assertNull("0 is not a perfect number", PerfectPower.isPerfectPower(0));
    }

    @Test
    public void test1() {
        assertNull("1 is not a perfect number", PerfectPower.isPerfectPower(1));
    }

    @Test
    public void test2() {
        assertNull("2 is not a perfect number", PerfectPower.isPerfectPower(2));
    }

    @Test
    public void test3() {
        assertNull("3 is not a perfect number", PerfectPower.isPerfectPower(3));
    }

    @Test
    public void test4() {
        assertArrayEquals("4 = 2^2", new int[]{2,2}, PerfectPower.isPerfectPower(4));
    }

    @Test
    public void test5() {
        assertNull("5 is not a perfect power", PerfectPower.isPerfectPower(5));
    }

    @Test
    public void test8() {
        assertArrayEquals("8 = 2^3", new int[]{2,3}, PerfectPower.isPerfectPower(8));
    }

    @Test
    public void test9() {
        assertArrayEquals("9 = 3^2", new int[]{3,2}, PerfectPower.isPerfectPower(9));
    }

    @Test
    public void testUpTo500() {
        int[] pp = {4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 81, 100, 121, 125, 128, 144, 169, 196, 216, 225, 243, 256, 289, 324, 343, 361, 400, 441, 484};
        for (int i: pp) assertNotNull(i+" is a perfect power", PerfectPower.isPerfectPower(i));
    }

    @Test
    @Ignore
    public void testRandomPerfectPowers() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int m = rnd.nextInt(254)+2;
            int k = (int)(rnd.nextDouble()*(log(Integer.MAX_VALUE)/log(m)-2.0)+2.0);
            int l = ipow(m, k);
            int[] r = PerfectPower.isPerfectPower(l);
            assertNotNull(l+" is a perfect power", r);
            assertEquals(r[0]+"^"+r[1]+"!="+l, l, ipow(r[0], r[1]));
        }
    }

    @Test
    @Ignore
    public void testRandomNumbers() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int l = rnd.nextInt(Integer.MAX_VALUE);
            int[] r = PerfectPower.isPerfectPower(l);
            if (r != null) assertEquals(r[0]+"^"+r[1]+"!="+l, l, ipow(r[0], r[1]));
        }
    }

    private static int ipow(int b, int e) {
        int p = 1;
        for (; e > 0; e >>= 1) {
            if ((e & 1) == 1) p *= b;
            b *= b;
        }
        return p;
    }
}
