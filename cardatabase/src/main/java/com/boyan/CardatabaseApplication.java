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
import com.boyan.domain.Owner;
import com.boyan.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	private CarRepository carRepository;
	
	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	private OwnerRepository ownerRepository;
	
	@Autowired
	public void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello Spring Boot");
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Add Owner objects and save them to DB
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);
			
			// Save Demo data to database
			carRepository.save(new Car("Ford", "Mustang", "Red",
						"ADF-1121", 2017, 59000, owner1));
			carRepository.save(new Car("Nisan", "Leaf", "White",
					"SSJ-3002", 2014, 29000, owner2));
			carRepository.save(new Car("Toyota", "Prius", "Silver",
					"KKO-5205", 2018, 39000, owner2));
			
		};
	}

}
