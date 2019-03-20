public class FoodFactory {
	public static Food createFood(String name){
		switch ( name ) {
			case "americano":
				return new Coffee(name, MenuHashMap.getPrice(name));
			case "cafelatte":
				return new Coffee(name, MenuHashMap.getPrice(name));
			default:
				return new Coffee("Error", -1);
		}	
	}
}
