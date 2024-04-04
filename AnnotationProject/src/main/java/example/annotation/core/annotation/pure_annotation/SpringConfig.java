package example.annotation.core.annotation.pure_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan  //Enables scanning of the all classes which annotated by @Component annotation
@ComponentScan(basePackages = {"food_item","dessert","example"})
public class SpringConfig {
    //@Bean declaration if any as per your requirement
}
