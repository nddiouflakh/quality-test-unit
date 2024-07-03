package sn.masterclass.servicecostumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import sn.masterclass.servicecostumer.entities.Customer;
import sn.masterclass.servicecostumer.repository.CustomerRepository;

@SpringBootApplication
public class ServiceCostumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCostumerApplication.class, args);
    }



@Bean
@Profile("!test")
CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
    return args -> {

        customerRepository.save(Customer.builder()
                .firstname("Moustapha")
                .lastname("SENE")
                .email("moustapha@gmail.com")
                .build());

        customerRepository.save(Customer.builder()
                .firstname("Fallou")
                .lastname("SENE")
                .email("fallou@gmail.com")
                .build());

        customerRepository.save(Customer.builder().firstname("Modou")
                .lastname("SENE").email("moudou@gmail.com").build());


        };
    }
}