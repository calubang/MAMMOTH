public class FoodFactory {
	public static Food createFood(String name){
		switch ( name ) {
			case "americano":
				System.out.println(name);
				return new Coffee(name, MenuHashMap.getPrice(name));
			case "cafelatte":
				return new Coffee(name, MenuHashMap.getPrice(name));
				//return new CafeLatte();
			default:
				return new Coffee("Error", -1);
		}	
	}
}
