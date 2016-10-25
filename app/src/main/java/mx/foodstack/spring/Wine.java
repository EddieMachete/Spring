package mx.foodstack.spring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eecheverria on 10/21/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wine {
    private String brand;

    public String getBrand() { return this.brand; }
}
