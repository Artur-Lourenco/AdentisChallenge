package adentischallenge.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import adentischallenge.entities.Item;
import adentischallenge.entities.Product;

public class ItemCreation {
	
	public static List<Item> createItems(LocalDateTime date) {
		List<Item> items = new ArrayList<>();
		
		Item item =  new Item(35.33, 2.32, 5.45, new Product("product", "category", 15.3, 35.33, date));
		
		items.add(item);
		
		return items;
	}

}
