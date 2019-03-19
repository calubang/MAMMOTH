import java.util.*;
class Test {
	public static void main(String[] args) 
	{
		HashMap<String, Integer> menuPrice = MenuHashMap.getInstance();
		menuPrice.put("americano", 900);
		menuPrice.put("cafelatte", 2100);
		menuPrice.put("cafemoca", 2200);
		
		//Iterator 
		Iterator<Map.Entry<String, Integer>> itr = menuPrice.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)itr.next();
			System.out.println(entry.getKey() + "    " +entry.getValue() );
		}
		
		int price = (Integer)menuPrice.get("americano");
		System.out.println(price);
		Food food = FoodFactory.createFood("americano");
		System.out.println("11");
		System.out.println(food.getName());
	}
}
