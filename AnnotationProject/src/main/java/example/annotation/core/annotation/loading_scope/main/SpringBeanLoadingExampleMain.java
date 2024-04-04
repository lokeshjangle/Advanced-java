package example.annotation.core.annotation.loading_scope.main;

import example.annotation.core.annotation.loading_scope.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanLoadingExampleMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annoCtx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        annoCtx.getBean("thirdMovie");
        Object obj1 = annoCtx.getBean("thirdMovie");
        Object obj2 = annoCtx.getBean("thirdMovie");
        //Singleton bean scope
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj1 == obj2);

        //Prototype bean Scope
        Object obj3 = annoCtx.getBean("fourthMovie");
        Object obj4 = annoCtx.getBean("fourthMovie");
        System.out.println(obj3);
        System.out.println(obj4);
        System.out.println(obj3 == obj4);
    }
}
