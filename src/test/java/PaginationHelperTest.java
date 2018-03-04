import org.junit.Ignore;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class PaginationHelperTest {
    PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList(), 4);


    @Test
    public void itemCount() {
        assertEquals(0, helper.itemCount());
    }

    @Test
    public void pageCount() {
        assertEquals(0, helper.pageCount());
    }

    @Test
    public void pageItemCount() {
        assertEquals(-1, helper.pageItemCount(0));
        assertEquals(-1, helper.pageItemCount(1));
        assertEquals(-1, helper.pageItemCount(2));
    }

    @Test
    public void pageIndex() {
        assertEquals(-1, helper.pageIndex(5));
        assertEquals(-1, helper.pageIndex(2));
        assertEquals(-1, helper.pageIndex(20));
        assertEquals(-1, helper.pageIndex(-10));
    }
}