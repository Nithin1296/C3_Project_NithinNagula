import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.AM;
import static java.util.Calendar.PM;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();


    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
//
//        Restaurant findRestaurantByName1 = new Restaurant("Amelie's cafe","Chennai", LocalTime.of(10,00),LocalTime.of(23,00));
//        Restaurant findRestaurantByName2 = new Restaurant("Pantry d'or","Chennai", LocalTime.of(10,00),LocalTime.of(23,00));
//        Restaurant findRestaurantByName3 = new Restaurant("Mauritius hotel","Chennai", LocalTime.of(10,00),LocalTime.of(23,00));
//
//        List<Restaurant> restaurants = Arrays.asList(findRestaurantByName1, findRestaurantByName2, findRestaurantByName3);

        Restaurant foundRestaurant = null;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
                foundRestaurant = restaurant;
                break;
            }
        }
        if (foundRestaurant == null) {
            throw new restaurantNotFoundException(restaurantName);
        }
        return foundRestaurant;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {

        return restaurants;
    }
}
