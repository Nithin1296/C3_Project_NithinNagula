import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Item {
    private String name;
    private int price;
    String selection;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return  name + ":"
                + price
                + "\n"
                ;
    }
    public int getPrice(){
        return price;
    }
//    public void setSelectedItem(String name) {
//       // name = Arrays.asList(name);
//        selection = (String) name;
//    }
//    public String getSelectedItem(){
//        return selection;
//    }
//    public int calculateCost(List Items){
//
//       Restaurant restaurant = new Restaurant("Amelie cae","Hyd", LocalTime.of(10,00),LocalTime.of(22,00));
//       int count = restaurant.getMenu().size();
//        for(int i=0; i<count;i++){
//            if(getName()==selection){
//                price+=price;
//
//            }
//        }
//
//            return price;
//    }

    }



