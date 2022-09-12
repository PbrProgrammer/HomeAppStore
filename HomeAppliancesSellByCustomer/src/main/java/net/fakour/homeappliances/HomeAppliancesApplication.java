package net.fakour.homeappliances;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
public class HomeAppliancesApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeAppliancesApplication.class, args);

    }

}
