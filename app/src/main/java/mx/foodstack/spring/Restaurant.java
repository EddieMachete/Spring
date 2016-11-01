package mx.foodstack.spring;

//import org.springframework.data.annotation.Id;

/**
 * Created by eecheverria on 10/21/2016.
 */

public class Restaurant {
    //@Id private String id;
    private String _id;
    private String name;

    public String get_id() {
        return this._id;
    }

    public String getName() {
        return this.name;
    }
}