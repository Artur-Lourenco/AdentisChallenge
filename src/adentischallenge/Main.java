package adentischallenge;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import adentischallenge.entities.Order;
import adentischallenge.entities.Product;
import adentischallenge.test.TestCreation;

public class Main {
	
	private static final int FIXED_INTERVAL_N = 4;
	private static final String FIXED_INTERVAL_1 = "1-3";
	private static final String FIXED_INTERVAL_2 = "4-6";
	private static final String FIXED_INTERVAL_3 = "7-12";
	private static final String FIXED_INTERVAL_4 = ">12";
	
	private static LocalDateTime intervalStart;
    private static LocalDateTime intervalEnd;
	
	public static void main(String[] args) {
		
		if(args.length < 2) {
			System.out.println("Invalid arguments. Input should be at least a time interval of two dates");
			return;
		}
		
		if(!checkIntervals(args[0], args[1])) {
			return;
		}
		
		List<Order> orders = TestCreation.createFictionalOrders();
		
		if(args.length == 2) {
			System.out.println("------------------------------");
			long[] counterArray = new long[FIXED_INTERVAL_N];
			orders.forEach( order -> {
				if(!order.getOrderPlacedDate().isAfter(intervalEnd) && 
						!order.getOrderPlacedDate().isBefore(intervalStart)) {
					for(int i = 0; i < order.getItems().size(); i++) {
						Product product = order.getItems().get(i).getProduct();
						LocalDateTime creationDate = product.getCreationDate();
						if(defCustomIntervals(creationDate, FIXED_INTERVAL_1))
							counterArray[0]++;
						if(defCustomIntervals(creationDate, FIXED_INTERVAL_2))
							counterArray[1]++;
						if(defCustomIntervals(creationDate, FIXED_INTERVAL_3))
							counterArray[2]++;
						if(defCustomIntervals(creationDate, FIXED_INTERVAL_4))
							counterArray[3]++;
					}
				}
			});
			System.out.println(FIXED_INTERVAL_1 + " months: " + counterArray[0] + " orders");
			System.out.println(FIXED_INTERVAL_2 + " months: " + counterArray[1] + " orders");
			System.out.println(FIXED_INTERVAL_3 + " months: " + counterArray[2] + " orders");
			System.out.println(FIXED_INTERVAL_4 + " months: " + counterArray[3] + " orders");
			System.out.println("------------------------------");
		} else {
			String[] customIntervals = Arrays.copyOfRange(args, 2, args.length);
			if(!isValidInterval(customIntervals))
				return;
			
			System.out.println("------------------------------");
			long[] counterArray = new long[customIntervals.length];
			orders.forEach(order -> {
				for(int i = 0; i < customIntervals.length; i++) {
					String s = customIntervals[i];
					if(!order.getOrderPlacedDate().isAfter(intervalEnd) && 
							!order.getOrderPlacedDate().isBefore(intervalStart)) {
						for(int j = 0; j < order.getItems().size(); j++) {
							Product product = order.getItems().get(j).getProduct();
							LocalDateTime creationDate = product.getCreationDate();
							if(defCustomIntervals(creationDate, s))
								counterArray[i]++;
						}
					}
				}
			});
			for(int i = 0; i < customIntervals.length; i++) {
				if(customIntervals[i].contains("-")) {
					String[] split = customIntervals[i].split("-");
					System.out.println(split[0] + "-" + split[1] + " months: " + counterArray[i] + " orders");
				}
				else
					System.out.println(">" + customIntervals[i].split(">")[1] +" months: " + counterArray[i] + " orders");
			}
			System.out.println("------------------------------");
		}
	}
	
	private static boolean checkIntervals(String date1, String date2) {
		try {
		DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		intervalStart = LocalDateTime.parse(date1, formatedDate);
		intervalEnd = LocalDateTime.parse(date2, formatedDate);
		
		return true;
		} catch (Exception e) {
			System.out.println("Invalid date format. Dates should be of format yyyy-MM-dd HH:mm:ss");
			return false;
		}
	}

	private static boolean isValidInterval(String[] args) {
		for (String string : args) {
			boolean type1 = string.contains("-");
			boolean type2 = string.contains(">");
			if(!type1 && !type2) {
				System.out.println("Valid intervals are of type X1-X2 or >X where X,X1 and X2 are numbers"
						+ " and X2 is greater than X1.");
				return false;
			} else if(type1 && type2) {
				System.out.println("Intervals can't be composed by '-' and '>' in the same interval.");
				return false;
			}
			if(type1) {
				String[] type1Array = string.split("-");
				if(type1Array.length != 2) {
					System.out.println("One interval can't have multiple '-'.");
					return false;
				} else if (Integer.parseInt(type1Array[0]) >= Integer.parseInt(type1Array[1])) {
					System.out.println("Intervals of type X1-X2 must have X2 greater than X1.");
					return false;
				}
			} else {
				String[] type2Array = string.split(">");
				if(type2Array.length != 2) {
					System.out.println("One interval can't have multiple '>'.");
					return false;
				} else if(!type2Array[0].equals("")) {
					System.out.println("Intervals of type '>X' can't have a number before '>'.");
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean defCustomIntervals(LocalDateTime creationDate, String s) {
		if(s.contains("-")) {
			String[] type1 = s.split("-");
			if(!creationDate.isAfter(intervalEnd.minusMonths(Integer.parseInt(type1[0]))) &&
					!creationDate.isBefore(intervalEnd.minusMonths(Integer.parseInt(type1[1]))))
					return true;
		} else {
			String[] type2 = s.split(">");
			if(creationDate.isBefore(intervalEnd.minusMonths(Integer.parseInt(type2[1]))))
				return true;
		}
		return false;
	}
}
