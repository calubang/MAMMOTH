import java.util.*;
class Test {
	
	public static void main(String[] args) 
	{	
		//가격표 설정
		HashMap<String, Integer> menuPrice = MenuHashMap.getInstance();
		menuPrice.put("americano", 900);
		menuPrice.put("cafelatte", 2100);
		menuPrice.put("cafemoca", 2200);
		//옵션별 가격 설정
		HashMap<String, Integer> optionPrice = OptionHashMap.getInstance();
		optionPrice.put("SYRUP_PRICE", 500);
		optionPrice.put("SHOT_PRICE", 500);
		
		
		//Iterator 
		Map.Entry<String, Integer> entry = null;
		Iterator<Map.Entry<String, Integer>> itr = menuPrice.entrySet().iterator();
		while(itr.hasNext()){
			entry = (Map.Entry<String, Integer>)itr.next();
			System.out.println(entry.getKey() + "\t" +entry.getValue() );
		}
		itr = optionPrice.entrySet().iterator();
		while(itr.hasNext()){
			entry = itr.next();
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		
		
		int price = (Integer)menuPrice.get("americano");
		//System.out.println(price);
		
		//System.out.println("11");
		Coffee coffee1 = (Coffee)FoodFactory.createFood(FoodType.COFFEE, "americano");
		coffee1.setHotIce(IceType.HOT);
		coffee1.setShotAmount(2);
		coffee1.setSyrupAmount(1);
		//System.out.println(coffee1);
		
		Coffee coffee2 = (Coffee)FoodFactory.createFood(FoodType.COFFEE, "cafelatte");
		coffee2.setHotIce(IceType.ICE);
		coffee2.setShotAmount(2);
		coffee2.setSyrupAmount(0);
		
		Coffee coffee3 = (Coffee)FoodFactory.createFood(FoodType.COFFEE, "cafemoca");
		coffee3.setHotIce(IceType.HOT);
		coffee3.setShotAmount(0);
		coffee3.setSyrupAmount(1);

		//test
		Order order = new Order((Food)coffee1);
		order.addList((Food)coffee2);
		order.addList((Food)coffee3);
		System.out.println(order);
		
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println(order.deleleList(2));
		System.out.println(order);
		
		
		
		
	}
}
