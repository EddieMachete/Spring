package mx.foodstack.spring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by eecheverria on 10/21/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantInfo implements Serializable {
    private String restaurantId;
    private String name;

    public String getRestaurantId() { return this.restaurantId; }
    public void setRestaurantId(String value) {
        this.restaurantId = value;
    }

    public String getName() { return this.name; }
    public void setName(String value) {
        this.name = value;
    }
}