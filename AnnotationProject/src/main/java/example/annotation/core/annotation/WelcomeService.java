package example.annotation.core.annotation;

public class WelcomeService implements GreetingService{


    @Override
    public String sayGreeting() {
        return "Welcome From Spring";
    }
}
