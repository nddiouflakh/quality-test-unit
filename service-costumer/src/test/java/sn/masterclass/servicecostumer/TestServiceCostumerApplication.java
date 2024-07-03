package sn.masterclass.servicecostumer;

import org.springframework.boot.SpringApplication;

public class TestServiceCostumerApplication {

    public static void main(String[] args) {
        SpringApplication.from(ServiceCostumerApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
