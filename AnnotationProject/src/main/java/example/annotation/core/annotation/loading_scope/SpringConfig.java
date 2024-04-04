package example.annotation.core.annotation.loading_scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
    @Bean
    public Movie firstMovie(){return new Movie();}
    @Bean
    public Movie secondMovie(){return new Movie();}
    @Bean
    @Lazy  //Tells Spring to instantiate this bean lazily;
    public Movie thirdMovie(){return new Movie();}

    @Bean
    @Lazy  //Tells Spring to instantiate this bean lazily;
    @Scope("prototype")
    public Movie fourthMovie(){return new Movie();}
}
