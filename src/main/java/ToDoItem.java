public class ToDoItem {
    int itemId;
    String itemDescription;
    boolean isComplete;

    public ToDoItem() {
    }

    public ToDoItem(int itemId, String itemDescription, boolean isComplete) {
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.isComplete = isComplete;
    }

    @Override
    public String toString() {
        String status = "complete";
        if (!isComplete) {
            status = "pending";
        }

        return itemId + ":" + itemDescription + ":" + isComplete;

    }
}
