package adentischallenge.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import adentischallenge.entities.Item;
import adentischallenge.entities.Order;

/**
 * Class created in order to emulate example given.
 * @author artur
 *
 */
public class TestCreation {
	
	private static final int FIRST = 200;
	private static final int SECOND = 150;
	private static final int THIRD = 50;
	private static final int FOURTH = 20;
	
	public static List<Order> createFictionalOrders() {
		List<Order> orders = new ArrayList<>();
		LocalDateTime firstDate = createTimes(LocalDate.of(2018, Month.OCTOBER, 01),
												LocalTime.of(0, 0, 0));
		LocalDateTime secondDate = createTimes(LocalDate.of(2018, Month.AUGUST, 01),
												LocalTime.of(0, 0, 0));
		LocalDateTime thirdDate = createTimes(LocalDate.of(2018, Month.MARCH, 01), 
												LocalTime.of(0, 0, 0));
		LocalDateTime fourthDate = createTimes(LocalDate.of(2017, Month.OCTOBER, 01), 
												LocalTime.of(0, 0, 0));
		
		List<Item> firstItem = ItemCreation.createItems(firstDate);
		List<Item> secondItem = ItemCreation.createItems(secondDate);
		List<Item> thirdItem = ItemCreation.createItems(thirdDate);
		List<Item> fourthItem = ItemCreation.createItems(fourthDate);
		
		for(int i = 0; i < FIRST; i++) {
			orders.add(new Order("José", "jose@gmail.com", "Rua A", 35.32, firstDate, firstItem));
		}
		for(int i = 0; i < SECOND; i++) {
			orders.add(new Order("Carlos", "carlos@gmail.com", "Rua B", 31.99, firstDate, secondItem));
		}
		for(int i = 0; i < THIRD; i++) {
			orders.add(new Order("João", "joao@gmail.com", "Rua C", 49.99, firstDate, thirdItem));
		}
		
		for(int i = 0; i < FOURTH; i++) {
			orders.add(new Order("Mário", "mario@gmail.com", "Rua D", 19.99, firstDate, fourthItem));
		}
		
		//Extra amount of orders outside range to check intervals accordingly
		for(int i = 0; i < FOURTH; i++) {
			orders.add(new Order("Zeca", "zeca@gmail.com", "Rua E", 5.99, fourthDate, fourthItem));
		}
		
		return orders;
	}
	
	private static LocalDateTime createTimes(LocalDate date, LocalTime time) {
		return LocalDateTime.of(date, time);
	}

}
