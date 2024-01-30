package example.hibernate.programmatic.bean;

//This class is simple Java Bean and not a JPA Entity
public class RestaurantNameAndCuisine {

    private String restaurantName;
    private String restaurantCuisine;

    //Constructor
    public RestaurantNameAndCuisine() {

    }
    public RestaurantNameAndCuisine(String restaurantName, String restaurantCuisine) {

        this.restaurantName = restaurantName;
        this.restaurantCuisine = restaurantCuisine;
    }

 //Getter and Setter Method
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantCuisine() {
        return restaurantCuisine;
    }

    public void setRestaurantCuisine(String restaurantCuisine) {
        this.restaurantCuisine = restaurantCuisine;
    }

    @Override
    public String toString() {
        return "RestaurantNameAndCuisine{" + "restaurantName='" + restaurantName + '\'' + ", restaurantCuisine='" + restaurantCuisine + '\'' + '}';
    }
}
