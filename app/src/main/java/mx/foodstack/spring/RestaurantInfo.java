package mx.foodstack.spring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eecheverria on 10/21/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantInfo {
    private String restaurantId;
    private String name;

    public String getRestaurantId() { return this.restaurantId; }
    public String getName() { return this.name; }
}