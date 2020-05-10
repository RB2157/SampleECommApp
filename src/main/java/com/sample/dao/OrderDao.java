package com.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.entities.OrderEntity;

/**
 * DAO class for Orders.
 * 
 * @author ronbaner
 *
 */
@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Long> {

	/**
	 * Persist into order: the order entity
	 * 
	 * @param orderId
	 * @param emailId
	 * @param itemId
	 * @param orderQuantity
	 */
	@Modifying
	@Query(value = "insert into orders (order_id, email_id, item_id, order_quantity) values (:order_id, :email_id, :item_id, :order_quantity)", nativeQuery = true)
	void insertOrder(@Param("order_id") Long orderId, @Param("email_id") String emailId, @Param("item_id") Long itemId,
			@Param("order_quantity") int orderQuantity);

	/**
	 * 
	 * 
	 * @param orderId
	 */
	@Modifying
	@Query(value = "Delete from orders where (order_id = :order_id)", nativeQuery = true)
	void deleteByOrderId(@Param("order_id") Long orderId);

	@Query(value = "select * from orders group by order_id", nativeQuery = true)
	List<OrderEntity> findDistinctOrders();

	@Query(value = "select * from orders where order_id = :order_id", nativeQuery = true)
	List<OrderEntity> findOrderById(@Param("order_id") Long orderId);

}
