package example.annotation.core.annotation.pure_annotation.main;

import dessert.IceCream;
import dessert.sundae.TrippleSundae;
import example.annotation.core.annotation.pure_annotation.Design;
import example.annotation.core.annotation.pure_annotation.Flower;
import example.annotation.core.annotation.pure_annotation.SpringConfig;
import food_item.Fruit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PureJavaBasedConfigurationExampleMain{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annoCtx = new AnnotationConfigApplicationContext(SpringConfig.class);

        Flower flowerObj = annoCtx.getBean(Flower.class);
        flowerObj.print();

        System.out.println("--------------------------------------");

        Design designObj = annoCtx.getBean(Design.class);
        designObj.print();

        System.out.println("--------------------------------------");
        Fruit fruitObj = annoCtx.getBean(Fruit.class);
        fruitObj.print();
        System.out.println("--------------------------------------");

        IceCream iceCream = annoCtx.getBean(IceCream.class);
        iceCream.print();
        System.out.println("--------------------------------------");

        TrippleSundae trippleSundae = annoCtx.getBean(TrippleSundae.class);
        trippleSundae.print();   }
}
