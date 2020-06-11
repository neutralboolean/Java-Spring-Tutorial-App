package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Bilbo", "Baggins", "hobbit hero")));
            log.info("Preloading " + employeeRepository.save(new Employee("Frodo", "Baggins", "Ringbearer")));
            orderRepository.save(new Order("Mackbooque Pro", Status.COMPLETED));
            orderRepository.save(new Order("uFone", Status.IN_PROGRESS));
            orderRepository.save(new Order("Sciborg", Status.CANCELLED));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
