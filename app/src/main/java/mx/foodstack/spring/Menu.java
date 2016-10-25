package mx.foodstack.spring;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eecheverria on 10/21/2016.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu {
    private String id;
    private int version;
    private RestaurantInfo restaurantInfo;

    @JsonProperty(value = "_id")
    public String getId() {
        return this.id;
    }

    public int getVersion() {
        return this.version;
    }
    public RestaurantInfo getRestaurantInfo() { return this.restaurantInfo; }

    private ArrayList<MenuItem> items = new ArrayList<MenuItem>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public ArrayList<MenuItem> getItems() { return this.items; }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
}