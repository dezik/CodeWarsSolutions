import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaginationHelper<I> {
    private Map<Integer, List<I>> pages = new HashMap<>();
    private int itemsCount = 0;
    private int itemsPerPage = 0;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        if (collection.size() > 0) {
            this.itemsCount = collection.size();
            this.itemsPerPage = itemsPerPage;
            for (int i = 0; i <= itemsCount / itemsPerPage; i++) {
                pages.put(i, collection.subList(
                        itemsPerPage * i,
                        (itemsPerPage * (i + 1)) > itemsCount ? itemsCount : (itemsPerPage * (i + 1))
                ));
            }
        }
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return itemsCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pages.size();
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex > pages.size() - 1 || pageIndex < 0) return -1;
        else return pages.get(pageIndex).size();
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex > itemsCount || itemIndex < 0) return -1;
        return itemIndex / itemsPerPage;
    }
}