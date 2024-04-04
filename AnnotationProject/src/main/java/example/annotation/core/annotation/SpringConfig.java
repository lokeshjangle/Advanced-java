package example.annotation.core.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration  //Marks this class as Configuration unit. It is equivalent to providing spring-config.xml
//With the help of @Configuration spring can understand this is configuration file/class
public class SpringConfig {
    @Bean  //This @Bean is told to spring is this method is not ordinary method it is Bean method
    //This is equivalent to <bean id="helloBean" class="..HelloService" /> in spring-config.xml
    public GreetingService helloBean(){
        GreetingService gs = new HelloService();
        return gs;  //gs will return the object of HelloService class
    }

    //Welcome Service bean
    @Bean("myWelcomeBean")
    public GreetingService welcomeBean(){
        GreetingService ws = new WelcomeService();
        return ws;
    }

    @Bean("setterBean")
    public GreetingService userBean(){
        UserService us = new UserService();
        us.setName("Lokesh");
        us.setMessage("Hey");
        us.setAge(23);
        return us;
    }

    @Bean("constructorBean")
    public GreetingService userBean2(){
        return new UserService("Sapna","Bye",25);
    }
    //Use for predefine list type
    @Bean("movieBean")
    public List<String> getMovie(){
        List<String> movie = List.of("Animal","Salar","PK");
        return movie;
    }
}
