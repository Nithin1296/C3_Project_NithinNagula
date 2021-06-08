import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;

    }


    public boolean isRestaurantOpen() {
        LocalTime currentTime = getCurrentTime();
        if (currentTime.isAfter(openingTime) && currentTime.isBefore(closingTime)) {
            return true;
        } else {
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
//
//        Item item1 = new Item("Sweet corn soup", 119);
//        Item item2 = new Item("Vegetable lasagne", 269);
//        Item item3 = new Item("Sizzling brownie", 319);
//
//        List<Item> menu = Arrays.asList(item1,item2,item3);

        return menu;

    }

    private Item findItemByName(String itemName) throws itemNotFoundException {
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;


    }


    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }


//
//    public int calculateSelectedItemsPrice(String[] selectItems){
//
//        int newPrice = 0;
//        //getMenu();
//
//        for(Item item: menu) {
//            for (String name : selectItems) {
//                if (item.getName().equals(name))
//                    newPrice = item.getPrice() + newPrice;
//
//            }
//        }
//
//        return newPrice;
//    }
}
