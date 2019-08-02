package com.boyan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.boyan.domain.Car;
import com.boyan.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	private CarRepository carRepository;
	
	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello Spring Boot");
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Save Demo data to database
			carRepository.save(new Car("Ford", "Mustang", "Red",
						"ADF-1121", 2017, 59000));
			carRepository.save(new Car("Nisan", "Leaf", "White",
					"SSJ-3002", 2014, 29000));
			carRepository.save(new Car("Toyota", "Prius", "Silver",
					"KKO-5205", 2018, 39000));
			
		};
	}

}
