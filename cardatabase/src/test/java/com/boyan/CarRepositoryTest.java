package com.boyan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.boyan.domain.Car;
import com.boyan.domain.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private CarRepository carRepository;
	
	@Test
	public void when_car_saved_then_not_null() {
		Car car = new Car("Test", "testModel", "testColor", "32324", 2015, 1000);
		testEntityManager.persistAndFlush(car);
		assertThat(car.getId()).isNotNull();
	}

	@Test
	public void when_cars_deleted_then_no_cars() {
		testEntityManager.persistAndFlush(new Car("ford", "combi", "red", "dsee22", 1999, 100));
		
		testEntityManager.persistAndFlush(new Car("zas", "speed", "blue", "dsee222", 1999, 1300));
		
		carRepository.deleteAll();
		
		assertThat(carRepository.findAll()).isEmpty();
		
	}
	
}
