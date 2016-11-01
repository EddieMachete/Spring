package mx.foodstack.spring;

/**
 * Created by eecheverria on 11/1/2016.
 */

public class MenuUseCases {
    private IRestaurantRepository mRestaurantRepository;

    public MenuUseCases(IRestaurantRepository restaurantRepository) {
        mRestaurantRepository = restaurantRepository;
    }

    public void GetMenuFor(String restaurantCode, String menuType) {

    }
}
