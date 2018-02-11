import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberOfTrailingZerosOfNTest {

    @Test
    public void zeros() {
        assertThat(NumberOfTrailingZerosOfN.zeros(0), is(0));
    }

    @Test
    public void zeros2() {
        assertThat(NumberOfTrailingZerosOfN.zeros(6), is(1));
    }

    @Test
    public void zeros3() {
        assertThat(NumberOfTrailingZerosOfN.zeros(14), is(2));
    }

    @Test
    public void zeros4() {
        assertThat(NumberOfTrailingZerosOfN.zeros(12), is(2));
    }

    @Test
    public void zeros5() {
        assertThat(NumberOfTrailingZerosOfN.zeros(30), is(7));
    }

    @Test
    public void zeros6() {
        assertThat(NumberOfTrailingZerosOfN.zeros(1000), is(249));
    }
}