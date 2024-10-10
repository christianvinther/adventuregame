public class Item {
    private String itemShortDescription;
    private String itemLongDescription;

    // Constructor to initialize item descriptions
    public Item(String itemShortDescription, String itemLongDescription){
        this.itemShortDescription = itemShortDescription;
        this.itemLongDescription = itemLongDescription;
    }

    // GETTERS for Item
    public String getItemShortDescription() {
        return itemShortDescription;
    }

    public String getItemLongDescription() {
        return itemLongDescription;
    }


}


