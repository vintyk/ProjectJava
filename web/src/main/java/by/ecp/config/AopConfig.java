package by.ecp.config;

import by.ecp.aspects.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Vinty on 05.07.2017.
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    @Bean
    public Logger logger() {
        return new Logger();
    }
}
