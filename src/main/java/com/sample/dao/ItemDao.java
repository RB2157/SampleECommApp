package com.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.entities.ItemEntity;

/**
 * DAO class for items.
 * 
 * @author ronbaner
 *
 */

@Repository
public interface ItemDao extends JpaRepository<ItemEntity, Long> {

	/**
	 * Finds item entity based on item id.
	 * 
	 * @param itemId
	 * @return item entity object
	 */
	ItemEntity findByItemId(Long itemId);

	/**
	 * 
	 * 
	 * @param itemId
	 * @return
	 */
	ItemEntity deleteByItemId(Long itemId);

	/**
	 * Updates the item quantity with @param remQuantity for item id @param currentItemId.
	 * 
	 * @param currentItemId
	 * @param remQuantity
	 */
	@Modifying
	@Query("update ItemEntity i set i.itemQuantity = :remQuantity where i.itemId = :currentItemId")
	void updateQuantity(@Param("currentItemId") Long currentItemId, @Param("remQuantity") int remQuantity);

}
