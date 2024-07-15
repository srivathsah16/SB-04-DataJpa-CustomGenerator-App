package com.srivath;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.srivath.entity.OrderDetails;
import com.srivath.repository.OrderRepository;

@SpringBootApplication
public class Sb04DataJpaCustomGeneratorAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Sb04DataJpaCustomGeneratorAppApplication.class,
				args);
		OrderRepository repo = context.getBean(OrderRepository.class);

		OrderDetails order1 = new OrderDetails();
		order1.setOrderBy("Yashodamma");
		order1 = repo.save(order1);
		System.out.println("order saved with id = " + order1.getOrderId());

		//***** Updating a record  ******
		
//		Optional<OrderDetails> optional = repo.findById("OD3");
//		OrderDetails ord = optional.get();
//		ord.setOrderBy("Harish");
//		repo.save(ord);

	}

}
