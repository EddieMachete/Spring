package mx.foodstack.spring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by eecheverria on 10/21/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItem {
    private int id;
    private String name;
    private String displayName;
    //private Wine wine;
    //private List<Integer> customizationIds;

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDisplayName() {
        return this.displayName;
    }
    //public Wine getWine() { return this.wine; }
    //public List<Integer> getCustomizationIds() { return this.customizationIds; }
}
