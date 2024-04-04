package example.annotation.core.annotation.main;

import example.annotation.core.annotation.GreetingService;
import example.annotation.core.annotation.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringAnnotationExampleMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annoCtx = new AnnotationConfigApplicationContext();  //It is predefined class provide by spring framework to retrive bean
        
        Class<SpringConfig> configClass = SpringConfig.class;
        annoCtx.register(configClass);  //Registering the configuration unit specific class
        annoCtx.refresh(); //Refreshing AnnotationConfigApplicationContext class to apply changes which is done by registring the bean class

        //Calling HelloServic Bean
        GreetingService gs = (GreetingService) annoCtx.getBean("helloBean");  //Getting relevant bean method/Id
        String  reply = gs.sayGreeting();
        System.out.println(reply);

        //Calling WelcomeService Bean
        GreetingService ws = (GreetingService) annoCtx.getBean("myWelcomeBean");
        reply = ws.sayGreeting();
        System.out.println(reply);

        //UserService for setter Method
        GreetingService us = (GreetingService) annoCtx.getBean("setterBean");
        reply = us.sayGreeting();
        System.out.println(reply);


        //UserService for Constructor Bean
        us = (GreetingService) annoCtx.getBean("constructorBean");
        reply = us.sayGreeting();
        System.out.println(reply);

        //Bean for List<String>
        List<String> movie = (List<String>) annoCtx.getBean("movieBean");
        movie.stream().forEach(m-> System.out.println(m));
    }
}
