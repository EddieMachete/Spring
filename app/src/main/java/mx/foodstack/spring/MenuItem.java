package mx.foodstack.spring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eecheverria on 10/21/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItem implements Serializable {
    private int id;
    private String name;
    private String displayName;
    //private Wine wine;
    //private List<Integer> customizationIds;

    public int getId() {
        return this.id;
    }
    public void setId(int value) {
        this.id = value;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String value) {
        this.name = value;
    }

    public String getDisplayName() {
        return this.displayName;
    }
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    //public Wine getWine() { return this.wine; }
    //public List<Integer> getCustomizationIds() { return this.customizationIds; }
}
