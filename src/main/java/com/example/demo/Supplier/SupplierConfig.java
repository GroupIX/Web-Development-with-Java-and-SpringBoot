package com.example.demo.Supplier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SupplierConfig {
    @Bean

    CommandLineRunner commandLineRunner(
            SupplierRepository repository){
        return args -> {
            Supplier Chandaria = new Supplier(

                    "Chandaria",
                    "Thika",
                    "ChandariaManU@gmail.com",
                    0700000000,
                    "355, Thika",
                    20201L
            );
            Supplier Kartasi = new Supplier(

                    "Kartasi",
                    "Thika",
                    "KartasiKasuku@gmail.com",
                    0710000001,
                    "320, Thika",
                    20202L
            );

             //Saving to database
            repository.saveAll(
                    List.of(Chandaria, Kartasi)
            );

        };
    }
}
