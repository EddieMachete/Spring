package mx.foodstack.spring;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eecheverria on 10/21/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable {
    private String id;
    private int version;
    private RestaurantInfo restaurantInfo;

    @JsonProperty(value = "_id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    public RestaurantInfo getRestaurantInfo() { return this.restaurantInfo; }
    public void setRestaurantInfo (RestaurantInfo value) {
        this.restaurantInfo = value;
    }

    private ArrayList<MenuItem> items = new ArrayList<MenuItem>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public ArrayList<MenuItem> getItems() { return this.items; }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
}