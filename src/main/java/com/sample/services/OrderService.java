package com.sample.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sample.dao.ItemDao;
import com.sample.dao.OrderDao;
import com.sample.dto.AddOrderDto;
import com.sample.dto.OrderItemDto;
import com.sample.entities.ItemEntity;
import com.sample.entities.OrderEntity;

/**
 * Service layer for order controller.
 * 
 * @author ronbaner
 *
 */
@Service
@Transactional
public class OrderService {
	
	private static final Logger LOGGER = LogManager.getLogger(OrderService.class);

	@Autowired
	private OrderDao orderRepository;

	@Autowired
	ItemDao itemRepository;

	@PostMapping("/addOrder")
	public ResponseEntity<Object> addOrder(AddOrderDto order) {
		LOGGER.debug("Into addOrder()");
		List<OrderItemDto> items = order.getItems();
		boolean placedOrder = false;
		boolean isUpdateFlow = true;
		if (order.getOrderId() == null) {
			order.setOrderId(System.nanoTime());
			isUpdateFlow = false;
		}
		if (!items.isEmpty()) {

			for (OrderItemDto item : items) {

				Long currentItemId = item.getItemId();
				int currentOrderQuantity = item.getOrderQuantity();
				if (currentItemId != null && itemRepository.findByItemId(currentItemId) != null) {

					ItemEntity itEntity = itemRepository.findByItemId(currentItemId);
					if (itEntity.getItemQuantity() >= currentOrderQuantity) {

						orderRepository.insertOrder(order.getOrderId(), order.getEmailId(), currentItemId,
								currentOrderQuantity);
						int remQuantity = itEntity.getItemQuantity() - currentOrderQuantity;
						itemRepository.updateQuantity(currentItemId, remQuantity);
						placedOrder = true;
						item.setOrderStatus("Success");
					} else {
						item.setOrderStatus("Failed. Available units :" + itEntity.getItemQuantity());
					}
				} else {
					item.setOrderStatus("Failed. Invalid item id");
				}

			}
			if (!placedOrder && !isUpdateFlow) {
				order.setOrderId(null);
			}
			return new ResponseEntity<>(order, new HttpHeaders(), HttpStatus.OK);
		}
		return new ResponseEntity<>("No Items Present", new HttpHeaders(), HttpStatus.OK);

	}

	@DeleteMapping("/deleteAllOrders")
	public ResponseEntity<Object> deleteAllOrders() {
		LOGGER.debug("Into deleteAllOrders()");
		String message;
		orderRepository.deleteAll();
		message = "Successfully Deleted All Orders";
		return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.OK);

	}

	@DeleteMapping("/deleteOrderById/{orderId}")
	public ResponseEntity<Object> deleteOrderById(Long orderId) {
		LOGGER.debug("Into deleteOrderById()");
		String message;
		orderRepository.deleteByOrderId(orderId);
		message = "Succesfully Deleted all orders with id =" + orderId;

		return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.OK);

	}
	
	@GetMapping("/allOrders")
	public ResponseEntity<Object> getAllOrders() {
		List<OrderEntity> orderEntities = orderRepository.findDistinctOrders();
		List<AddOrderDto> orders = new ArrayList<>();

		if (null != orderEntities) {
			for (OrderEntity orderEntity : orderEntities) {
				AddOrderDto order = new AddOrderDto();
				order.setEmailId(orderEntity.getEmailId());
				order.setOrderId(orderEntity.getOrderId());
				order.setItems(createItemList(orderEntity.getOrderId()));
				orders.add(order);
			}
		}
		return new ResponseEntity<>(orders, new HttpHeaders(), HttpStatus.OK);

	}
	
	private List<OrderItemDto> createItemList(Long orderId) {
		List<OrderEntity> orderEntities = orderRepository.findOrderById(orderId);
		List<OrderItemDto> itemList = new ArrayList<>();
		if (null != orderEntities) {

			for (OrderEntity orderEntity : orderEntities) {

				OrderItemDto item = new OrderItemDto();
				item.setItemId(orderEntity.getItemId());
				item.setOrderQuantity(orderEntity.getOrderQuantity());
				itemList.add(item);
			}
			return itemList;
		}
		return null;

	}

}
