package com.sample.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sample.dao.ItemDao;
import com.sample.dto.AddItemDto;
import com.sample.dto.wrappers.AddItemDtoWrapper;
import com.sample.entities.ItemEntity;

/**
 * Service layer for Item controller.
 * 
 * @author ronbaner
 *
 */

@Service
public class ItemService {

	private static final Logger LOGGER = LogManager.getLogger(ItemService.class);

	@Autowired
	private ItemDao itemRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<Object> getAllItems() {
		LOGGER.debug("Into getAllItems()");
		List<ItemEntity> itemEntityList = itemRepository.findAll();
		return new ResponseEntity<>(itemEntityList, new HttpHeaders(), HttpStatus.OK);
	}

	public ResponseEntity<Object> getItemById(@PathVariable("id") Long itemId) {
		LOGGER.debug("Into getItemById()");
		ItemEntity itemEntity = itemRepository.findByItemId(itemId);
		return new ResponseEntity<>(itemEntity, new HttpHeaders(), HttpStatus.OK);
	}

	public ResponseEntity<Object> deleteAllItems() {
		LOGGER.debug("Into deleteAllItems()");
		String message;
		itemRepository.deleteAll();
		message = "Successfully Deleted All Items";
		return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.OK);
	}

	public ResponseEntity<Object> deleteItemById(Long itemId) {
		LOGGER.debug("Into deleteItemById()");
		ItemEntity itemEntity = itemRepository.deleteByItemId(itemId);
		return new ResponseEntity<>(itemEntity, new HttpHeaders(), HttpStatus.OK);
	}

	public ResponseEntity<Object> addItems(AddItemDtoWrapper items) {
		LOGGER.debug("Into addItems()");
		List<AddItemDto> itemList = items.getItems();
		List<AddItemDto> newitemList = new ArrayList<>();
		if (!itemList.isEmpty()) {
			for (AddItemDto item : itemList) {
				if (item.getItemId() == null) {
					item.setItemId(System.nanoTime());
					item.setmessage("Item Added");
				} else {
					item.setmessage("Item Updated");
				}
				ItemEntity itemEntity = modelMapper.map(item, ItemEntity.class);
				itemRepository.save(itemEntity);

				newitemList.add(item);

			}
			return new ResponseEntity<>(newitemList, new HttpHeaders(), HttpStatus.OK);
		}
		return null;

	}

}
