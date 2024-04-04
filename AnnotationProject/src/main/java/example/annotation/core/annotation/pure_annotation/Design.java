package example.annotation.core.annotation.pure_annotation;

import org.springframework.stereotype.Component;

@Component
public class Design {
    public Design(){
        System.out.println("Design Instantiated");
    }

    public void print(){
        System.out.println("It is new design");
    }
}
