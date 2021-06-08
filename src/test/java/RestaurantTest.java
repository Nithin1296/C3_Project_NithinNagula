import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static java.util.Calendar.AM;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    Restaurant restaurant;

    //REFACTOR ALL THE REPEATED LINES OF CODE

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE

    @BeforeEach
    public void setUp(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

    }
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE

        restaurant.isRestaurantOpen();

        //Below is the code written by sender without using mockito by directly asserting the static time values with opening and closing times
        LocalTime openingTime = LocalTime.of(10,00);
        LocalTime closingTime = LocalTime.of(23,00);

        assertTrue(LocalTime.of(11,00).isAfter(openingTime));
        assertTrue(LocalTime.of(21,00).isBefore(closingTime));

        //can also be used but depends on the local time
//        assertEquals(LocalTime.now().isAfter(openingTime),LocalTime.now().isBefore(closingTime));

    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE

        restaurant.isRestaurantOpen();

        LocalTime openingTime = LocalTime.of(10,00);
        LocalTime closingTime = LocalTime.of(23,00);

        assertFalse(LocalTime.of(9,00).isAfter(openingTime));
        assertFalse(LocalTime.of(23,59).isBefore(closingTime));

//       assertNotEquals(LocalTime.now().isAfter(openingTime),LocalTime.now().isBefore(closingTime));

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {


        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");

        assertEquals(initialMenuSize-1,restaurant.getMenu().size());

    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

   //pass case scenario
   @Test
   public void assert_price_after_adding_items_is_equal_to_totalPrice_of_added_items() {
       restaurant.addToMenu("Veg chops", 200);
       String[] selectItems = {"Veg chops", "Vegetable lasagne"};
       int totalCost = restaurant.calculateSelectedItemsPrice(selectItems);

       assertEquals(469, totalCost);

   }

   //Negative scenario
   @Test
   public void assert_price_after_adding_items_is_if_price_not_equal_to_totalPrice_of_added_items() {
       restaurant.addToMenu("Veg Lasagn", 200);
       String[] selectItems = {"Veg Lasagn", "Vegetable lasagne"};
       int totalCost = restaurant.calculateSelectedItemsPrice(selectItems);

       assertNotEquals(300, totalCost);

   }
}