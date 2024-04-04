package food_item;

import org.springframework.stereotype.Component;

@Component
public class Fruit {
    public Fruit(){System.out.println("Fruit Instantiated");}

    public void print(){
        System.out.println("My Favourite fruit is Mango");
    }
}
