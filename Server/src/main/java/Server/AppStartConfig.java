package Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="Server")
public class AppStartConfig{
 
	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppStartConfig.class);
        app.run(args);
    }
	
}
