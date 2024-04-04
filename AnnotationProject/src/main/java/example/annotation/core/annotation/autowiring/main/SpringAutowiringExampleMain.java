package example.annotation.core.annotation.autowiring.main;

import example.annotation.core.annotation.autowiring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAutowiringExampleMain {
    public static void main(String[] args) {


        Class<SpringConfig> configClass = SpringConfig.class;
        AnnotationConfigApplicationContext annoCtx = new AnnotationConfigApplicationContext(configClass);
        //This version of constructor of AnnotationConfigApplicationContext will perform register() and refresh() method so no need to call this method separately

        Object obj = annoCtx.getBean("myCar");
        System.out.println(obj);
    }
}
