package co.uk.neelsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PrimesApiApp {

    public static void main(String args[]){
        SpringApplication.run(PrimesApiApp.class);
    }

}
