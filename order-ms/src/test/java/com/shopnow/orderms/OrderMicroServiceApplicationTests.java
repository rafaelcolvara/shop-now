package com.shopnow.orderms;

import com.shopnow.orderms.entity.Order;
import com.shopnow.orderms.repo.RepositoryOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
class OrderMicroServiceApplicationTests {


	@Autowired
	private RepositoryOrder repositoryOrder;

	@Test
	public void testSaveAndFind() {
		Order order = new Order(1L);

		repositoryOrder.save(order);

		Optional<Order> foundOrder = repositoryOrder.findById(order.getId());
		assertTrue(foundOrder.isPresent());
		assertEquals(order.getId(), foundOrder.get().getId());

	}


}