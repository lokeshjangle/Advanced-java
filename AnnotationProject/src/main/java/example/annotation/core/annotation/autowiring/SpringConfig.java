package example.annotation.core.annotation.autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringConfig {
    @Bean
    public Engine myEngine(){
        return new Engine();
    }

    @Bean
    @Primary
    public MusicSystem myMusicSystem(){
        return new MusicSystem();
    }
    @Bean
    public MusicSystem myMusicSystem2(){
        return new MusicSystem("Panasonic","mono");
    }
    @Bean
    public Car myCar(){
        Car myCar = new Car();
        myCar.setMake("JEEP");
        myCar.setModel("COMPASS");
        myCar.setPrice(3000000);
        return myCar;

        ///Values are not being set for the properties engineDetails and musicSystemDetails, Because we want spring to autowired them
    }

}
