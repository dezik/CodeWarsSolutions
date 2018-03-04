import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AmazonTestTest {

    @Test
    public void getSubstrsTest() {
        List<String> list = AmazonTest.getSubstrs("democracy", 5);
        assertTrue(list.size() == 2);
        assertTrue(list.contains("ocrac"));
        assertTrue(list.contains("cracy"));
    }

    @Test
    public void getSubstrsTest2() {
        List<String> list = AmazonTest.getSubstrs("omommama", 4);
        assertTrue(list.size() == 1);
        assertTrue(list.contains("omma"));
    }
}