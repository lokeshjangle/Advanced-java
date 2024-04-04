package example.annotation.core.annotation.pure_annotation;

import org.springframework.stereotype.Component;

@Component //Marks this class as a Managed Component
public class Flower {
    public Flower(){ System.out.println("Flower Instantiated");}

    public void print(){
        System.out.println("My favourite flower is Rose");
    }
}
